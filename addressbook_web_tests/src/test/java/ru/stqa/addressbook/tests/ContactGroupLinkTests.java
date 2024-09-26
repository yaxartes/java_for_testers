package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.Comparator;

public class ContactGroupLinkTests extends TestBase {
    @Test
    void canAddContactToGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData().withId("")
                    .withName(Common.randomString(10))
                    .withHeader(Common.randomString(10))
                    .withFooter(Common.randomString(10)));
        }
        app.hbm().createContact(new ContactData().withEssentialFields(Common.randomString(5),
                Common.randomString(6),
                Common.randomString(7)));

        var group = app.hbm().getGroupList().get(0);
        var contacts = app.hbm().getContactList();
        var id = contacts.size() - 1;
        var newContact = contacts.get(id);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().addContactToGroup(newContact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newRelated.sort(compareById);

        var expected = new ArrayList<>(oldRelated);
        expected.add(newContact.withId(newRelated.get(newRelated.size() - 1).id()).withPhoto(""));
        expected.sort(compareById);

        Assertions.assertEquals(newRelated, expected);
    }

    @Test
    void canRemoveContactFromGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData(
                    "",
                    "group name",
                    "group header",
                    "group footer"));
        }

        app.hbm().createContact(new ContactData().withEssentialFields(Common.randomString(5),
                Common.randomString(6),
                Common.randomString(7)));

        var contacts = app.hbm().getContactList();
        var id = contacts.size() - 1;
        var contact = contacts.get(id);
        var group = app.hbm().getGroupList().get(0);
        app.contacts().addContactToGroup(contact, group);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().removeContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };

        newRelated.sort(compareById);
        var expected = new ArrayList<>(oldRelated);
        expected.remove(contact);
        expected.sort(compareById);

        Assertions.assertEquals(newRelated, expected);
    }
}

