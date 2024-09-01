package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openHomePage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        deleteSelectedContact();
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void deleteSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("address"), contact.address());
        type(By.name("middlename"), contact.middleName());
        type(By.name("nickname"), contact.nickname());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("home"), contact.homePhone());
        type(By.name("mobile"), contact.mobilePhone());
        type(By.name("work"), contact.workPhone());
        type(By.name("fax"), contact.fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
        attach(By.name("photo"), contact.photo());
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void openHomePage() {
        click(By.linkText("home"));
        timeout(1);
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var spans = manager.driver.findElements(By.xpath("//tr[@name=\"entry\"]"));
        for (var span : spans) {
            var fieldsList = span.findElements(By.cssSelector("td"));
            var lastName = fieldsList.get(1).getText();
            var firstName = fieldsList.get(2).getText();
            var address = fieldsList.get(3).getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withEssentialFields(lastName, firstName, address));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        editContact(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        openHomePage();
    }

    private void submitContactModification() {
        click(By.xpath("(//input[@name=\'update\'])[2]"));
    }

    private void editContact(ContactData contact) {
        click(By.xpath(String.format("//input[@value='%s']/ancestor::tr/td//*[@title=\"Edit\"]", contact.id())));
    }
}
