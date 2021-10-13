package by.egar.addressbook.model;

import java.util.Objects;

public record ContactDatas(String firstname, String lastname, String email, String group) {
    @Override
    public String toString() {
        return "ContactDatas{" +
                "firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDatas that = (ContactDatas) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, group);
    }
}