package by.egar.addressbook.model;

import java.util.Objects;

public class ContactDatas {
    private int id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String group;

    public ContactDatas(String firstname, String lastname, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
    }

    public ContactDatas(int id, String firstname, String lastname, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname);
    }

}