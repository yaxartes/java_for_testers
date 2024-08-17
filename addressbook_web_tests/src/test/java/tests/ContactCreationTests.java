package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void canCreateContact() {
    var contact = new ContactData().withEssentialFields("Ivanov", "Ivan", "620000, Ekaterinburg, 1 Lenin str.");
    app.contacts().createContact(contact);
  }

  @Test
  public void canCreateContactWithEmptyFields() {
    app.contacts().createContact(new ContactData());
  }
}
