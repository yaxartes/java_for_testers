package ru.stqa.addressbook.manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "lastname")
    public String lastName;

    @Column(name = "firstname")
    public String firstName;

    @Column(name = "address")
    public String address;

    @Column(name = "middlename")
    public String middleName;

    @Column(name = "nickname")
    public String nickname;

    @Column(name = "title")
    public String title;

    @Column(name = "company")
    public String company;

    @Column(name = "home")
    public String homePhone;

    @Column(name = "mobile")
    public String mobilePhone;

    @Column(name = "work")
    public String workPhone;

    public String phone2;

    @Column(name = "fax")
    public String fax;

    @Column(name = "email")
    public String email;

    @Column(name = "email2")
    public String email2;

    @Column(name = "email3")
    public String email3;

    @Column(name = "homepage")
    public String homepage;

    public ContactRecord() {

    }

    public ContactRecord(int id,
                         String lastName,
                         String firstName,
                         String address,
                         String middleName,
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
                         String homepage
    ) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.middleName = middleName;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
    }

}
