package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

  public static List<ContactData> contactProvider() {
    var result = new ArrayList<ContactData>();
    for (int i = 0; i < 4; i++) {
      result.add(new ContactData().withTextFields(
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomPhone(i * 10),
              randomPhone(i * 10),
              randomPhone(i * 10),
              randomPhone(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10),
              randomString(i * 10)
              ));
    }
    return result;
  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreateContact(ContactData contact) {
    int contactCount = app.contacts().getCount();
    app.contacts().createContact(contact);
    int newContactCount = app.contacts().getCount();

    Assertions.assertEquals(contactCount + 1, newContactCount);
  }
}
