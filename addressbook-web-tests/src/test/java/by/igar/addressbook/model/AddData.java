package by.igar.addressbook.model;

public class AddData {
    private final String name;
    private final String header;
    private final String footer;

    public AddData(String name, String headar, String footer) {
        this.name = name;
        this.header = headar;
        this.footer = footer;
    }
    public String getName() { return name; }

    public String getHeadar() { return header; }

    public String getFooter() { return footer; }

}
