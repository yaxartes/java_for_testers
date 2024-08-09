package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void canCreateContact() {
    app.contacts().createContact(new ContactData("Ivanov", "Ivan", "620000, Ekaterinburg, 1 Lenin str."));
  }
}
