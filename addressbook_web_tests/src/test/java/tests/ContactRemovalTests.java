package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemoveContact() {
    if (app.contacts().getCount() == 0) {
      app.contacts().createContact(new ContactData().withEssentialFields("Ivanov", "Ivan", "Default Address"));
    }
    var oldContactList = app.contacts().getList();
    var rnd = new Random();
    var index = rnd.nextInt(oldContactList.size());

    var expectedContactList = new ArrayList<>(oldContactList);
    expectedContactList.remove(index);

    app.contacts().removeContact(oldContactList.get(index));

    var newContactList = app.contacts().getList();
    Assertions.assertEquals(newContactList, expectedContactList);
  }
}
