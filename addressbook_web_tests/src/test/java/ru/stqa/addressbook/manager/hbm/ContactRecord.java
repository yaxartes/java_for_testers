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

    public ContactRecord() {

    }

    public ContactRecord(int id, String lastName, String firstName, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }

}
