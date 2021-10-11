package by.igar.addressbook.model;

public class GroupData2 {
    private final String name;
    private final String header;
    private final String footer;

    public GroupData2(String name, String headar, String footer) {
        this.name = name;
        this.header = headar;
        this.footer = footer;
    }
    public String getName() { return name; }

    public String getHeadar() { return header; }

    public String getFooter() { return footer; }

}
