package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData()
                    .withEssentialFields(randomString(20), randomString(20), randomString(20)));
        }

        var oldContactList = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContactList.size());
        var testData = new ContactData()
                .withEssentialFields(randomString(5), randomString(5), randomString(5));

        app.contacts().modifyContact(oldContactList.get(index), testData);

        var newContactList = app.contacts().getList();
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
