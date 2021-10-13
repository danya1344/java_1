package by.egar.addressbook.model;

import java.util.Objects;

public record ContactDatas(String id, String firstname, String lastname, String email, String group) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDatas that = (ContactDatas) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname);
    }

    @Override
    public String toString() {
        return "ContactDatas{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    public String getId() {
        return null;
    }
}