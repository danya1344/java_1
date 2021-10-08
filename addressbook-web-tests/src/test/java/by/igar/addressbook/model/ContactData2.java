package by.igar.addressbook.model;

public class ContactData2 {
    private final String firstname;
    private final String secondname;
    private String group;

    public ContactData2(String firstname, String secondname, String group) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.group = group;
    }
    public String getFirstname() { return firstname; }
    public String getSecondname() { return secondname; }

    public String getGroup() {
        return group;
    }
}
