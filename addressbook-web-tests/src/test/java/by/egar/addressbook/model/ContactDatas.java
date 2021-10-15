package by.egar.addressbook.model;

import java.util.Objects;

public class ContactDatas {
    private int id = Integer.MAX_VALUE;;
    private String firstname;
    private String lastname;
    private String email;
    private String group;


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

    public ContactDatas withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDatas withGroup(String group) {
        this.group = group;
        return this;
    }


    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getGroup() {
        return group;
    }


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