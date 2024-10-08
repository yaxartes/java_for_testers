package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withEssentialFields(Common.randomString(20),
                            Common.randomString(20),
                            Common.randomString(20)));
        }

        var oldContactList = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContactList.size());
        var testData = new ContactData()
                .withEssentialFields(Common.randomString(5),
                        Common.randomString(5),
                        Common.randomString(5));

        app.contacts().modifyContact(oldContactList.get(index), testData);

        var newContactList = app.hbm().getContactList();
        var expectedContactList = new ArrayList<>(oldContactList);
        expectedContactList.set(index, testData.withId(oldContactList.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContactList.sort(compareById);
        expectedContactList.sort(compareById);
        Assertions.assertEquals(newContactList, expectedContactList);
    }
}
