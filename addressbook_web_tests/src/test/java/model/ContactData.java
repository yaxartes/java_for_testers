package model;

public record ContactData(String lastName,
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
                          String group) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "");
    }

    public ContactData withEssentialFields(String lastName, String firstName, String address) {
        return new ContactData(lastName,
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
                this.group);
    }
}
