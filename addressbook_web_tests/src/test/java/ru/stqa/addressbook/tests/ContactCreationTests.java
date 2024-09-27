package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends ru.stqa.addressbook.tests.TestBase {

  public static List<ContactData> contactProvider() throws IOException {
    var result = new ArrayList<ContactData>();
    var json = "";
    try (var reader = new FileReader("contacts.json");
         var breader = new BufferedReader(reader)
    ) {
      var line = breader.readLine();
      while (line != null) {
        json = json + line;
        line = breader.readLine();
      }
    }
    ObjectMapper mapper = new ObjectMapper();
    var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
    result.addAll(value);
    return result;
  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreateContact(ContactData contact) {
    var oldContactList = app.hbm().getContactList();
    app.contacts().createContact(contact);

    var newContactList = app.hbm().getContactList();
    var extraContacts = newContactList.stream().filter(c -> ! oldContactList.contains(c)).toList();
    var newId = extraContacts.get(0).id();
    var expectedContactList = new ArrayList<>(oldContactList);
    expectedContactList.add(contact.withId(newId).withPhoto(""));

    Assertions.assertEquals(Set.copyOf(newContactList), Set.copyOf(expectedContactList));
  }

  @Test
  public void canCreateContactInGroup() {
    var contact = new ContactData()
            .withEssentialFields(Common.randomString(5), Common.randomString(6), Common.randomString(7))
            .withPhoto("src/test/resources/images/avatar.png");

    if (app.hbm().getGroupCount() == 0) {
      app.hbm().createGroup(new GroupData(
              "",
              "group name",
              "group header",
              "group footer"));
    }
    var group = app.hbm().getGroupList().get(0);

    var oldRelated = app.hbm().getContactsInGroup(group);
    app.contacts().createContact(contact, group);
    var newRelated = app.hbm().getContactsInGroup(group);
    Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
  }
}
