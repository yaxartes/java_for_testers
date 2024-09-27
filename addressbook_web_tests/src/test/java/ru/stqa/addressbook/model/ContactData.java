package ru.stqa.addressbook.model;

public record ContactData(String id,
                          String lastName,
                          String middleName,
                          String firstName,
                          String address,
                          String nickname,
                          String title,
                          String company,
                          String homePhone,
                          String mobilePhone,
                          String workPhone,
                          String fax,
                          String email,
                          String email2,
                          String email3,
                          String homepage,
                          String birthday,
                          String anniversary,
                          String group,
                          String photo,
                          String secondaryPhone) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withEssentialFields(String lastName, String firstName, String address) {
        return new ContactData(
                this.id,
                lastName,
                this.middleName,
                firstName,
                address,
                this.nickname,
                this.title,
                this.company,
                this.homePhone,
                this.mobilePhone,
                this.workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                this.secondaryPhone);
    }

    public ContactData withTextFields(String lastName,
                                      String middleName,
                                      String firstName,
                                      String address,
                                      String nickname,
                                      String title,
                                      String company,
                                      String homePhone,
                                      String mobilePhone,
                                      String workPhone,
                                      String fax,
                                      String email,
                                      String email2,
                                      String email3,
                                      String homepage) {
        return new ContactData(
                this.id,
                lastName,
                middleName,
                firstName,
                address,
                nickname,
                title,
                company,
                homePhone,
                mobilePhone,
                workPhone,
                fax,
                email,
                email2,
                email3,
                homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                this.secondaryPhone);
    }

    public ContactData withId(String id) {
        return new ContactData(
                id,
                this.lastName,
                this.middleName,
                this.firstName,
                this.address,
                this.nickname,
                this.title,
                this.company,
                this.homePhone,
                this.mobilePhone,
                this.workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                this.secondaryPhone);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(
                this.id,
                this.lastName,
                this.middleName,
                this.firstName,
                this.address,
                this.nickname,
                this.title,
                this.company,
                this.homePhone,
                this.mobilePhone,
                this.workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                photo,
                this.secondaryPhone);
    }

    public ContactData withHomePhone(String homePhone) {
        return new ContactData(
                this.id,
                this.lastName,
                this.middleName,
                this.firstName,
                this.address,
                this.nickname,
                this.title,
                this.company,
                homePhone,
                this.mobilePhone,
                this.workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                this.secondaryPhone);
    }

    public ContactData withMobilePhone(String mobilePhone) {
        return new ContactData(
                this.id,
                this.lastName,
                this.middleName,
                this.firstName,
                this.address,
                this.nickname,
                this.title,
                this.company,
                this.homePhone,
                mobilePhone,
                this.workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                this.secondaryPhone);
    }

    public ContactData withWorkPhone(String workPhone) {
        return new ContactData(
                this.id,
                this.lastName,
                this.middleName,
                this.firstName,
                this.address,
                this.nickname,
                this.title,
                this.company,
                this.homePhone,
                this.mobilePhone,
                workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                this.secondaryPhone);
    }

    public ContactData withSecondaryPhone(String secondaryPhone) {
        return new ContactData(
                this.id,
                this.lastName,
                this.middleName,
                this.firstName,
                this.address,
                this.nickname,
                this.title,
                this.company,
                this.homePhone,
                this.mobilePhone,
                this.workPhone,
                this.fax,
                this.email,
                this.email2,
                this.email3,
                this.homepage,
                this.birthday,
                this.anniversary,
                this.group,
                this.photo,
                secondaryPhone);
    }
}
