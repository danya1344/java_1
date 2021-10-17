package by.egar.addressbook.model;

import java.util.Objects;

public class ContactDatas {
    private int id = Integer.MAX_VALUE;;
    private String firstname;
    private String lastname;
    private String group;
    private String home;
    private String mobile;
    private String work;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;
    private String address;



    public int getId() {
        return id;
    }

    public ContactDatas withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDatas withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactDatas withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactDatas withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactDatas withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public ContactDatas withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactDatas withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public ContactDatas withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactDatas withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDatas withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDatas withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactDatas withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactDatas withAddress(String address) {
        this.address = address;
        return this;
    }





    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getGroup() {
        return group;
    }
    public String getHomePhone() {
        return home;
    }
    public String getMobilePhone() {
        return mobile;
    }
    public String getWorkPhone() {
        return work;
    }
    public String getAllPhones() {
        return allPhones;
    }
    public String getEmail() {
        return email;
    }
    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
        return email3;
    }
    public String getAllEmails() {
        return allEmails; }
    public String getAddress() { return address; }



    @Override
    public String toString() {
        return "ContactDatas{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDatas that = (ContactDatas) o;
        return id == that.id && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname);
    }

}