package by.sqa.addressbook.model;

import java.util.Objects;

public class GroupData {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;


    public int getId() {
        return id;
    }

    public GroupData getName(String name) {
        this.name = name;
        return this;
    }

    public GroupData getHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData getFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public String getName() {
        return name;
    }
    public String getHeader() {
        return header;
    }
    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData(" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData that = (GroupData) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
