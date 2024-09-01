package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  public static List<ContactData> contactProvider() {
    var result = new ArrayList<ContactData>();
    for (int i = 0; i < 4; i++) {
      result.add(new ContactData().withEssentialFields(
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10)
              ).withPhoto(randomFile("src/test/resources/images")));
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
