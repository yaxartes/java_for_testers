package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{
    @Test
    void testPhones() {
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone(), contact.secondaryPhone())
                    .filter(p -> p != null && !p.isEmpty())
                    .collect(Collectors.joining("/n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }
}
