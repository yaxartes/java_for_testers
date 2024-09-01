package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemoveContact() {
    if (app.contacts().getCount() == 0) {
      app.contacts().createContact(new ContactData()
              .withEssentialFields(Common.randomString(20), Common.randomString(20), Common.randomString(20)));
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
