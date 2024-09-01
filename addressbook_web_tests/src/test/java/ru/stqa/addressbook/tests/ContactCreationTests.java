package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends ru.stqa.addressbook.tests.TestBase {

  public static List<ContactData> contactProvider() {
    var result = new ArrayList<ContactData>();
    for (int i = 0; i < 4; i++) {
      result.add(new ContactData().withEssentialFields(
              Common.randomString(i * 10),
              Common.randomString(i * 10),
              Common.randomString(i * 10)
              ).withPhoto(Common.randomFile("src/test/resources/images")));
    }
    return result;
  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreateContact(ContactData contact) {
    var oldContactList = app.contacts().getList();
    app.contacts().createContact(contact);

    var newContactList = app.contacts().getList();
    Comparator<ContactData> compareById = (o1, o2) -> {
      return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
    newContactList.sort(compareById);

    var expectedContactList = new ArrayList<>(oldContactList);
    expectedContactList.add(contact.withId(newContactList.get(newContactList.size() - 1).id()).withPhoto(""));
    expectedContactList.sort(compareById);

    Assertions.assertEquals(newContactList, expectedContactList);
  }
}
