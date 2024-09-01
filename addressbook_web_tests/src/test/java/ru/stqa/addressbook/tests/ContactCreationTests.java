package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.model.ContactData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
