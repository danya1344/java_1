package by.igar.addressbook.appmanager;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper2 extends BaseHelper2 {

    public GroupHelper2(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation(String submit) {
        wd.findElement(By.name(submit)).click();
    }

    public void fillGroupForm(GroupData test1) {
        initGroupName("firstname", "middlename", "lastname", "nickname");
        initGroupHeader("title", "company", "address", "home");
        initGroupFooter();
        initGroupID("address2", "phone2", "notes");
    }

    public void initGroupID(String address2, String phone2, String notes) {
        type(address2, phone2, notes);
    }

    public void initGroupFooter() {
        type("mobile", "work", "fax");
        type("email", "email2", "email3");
        type("homepage", "bday", "bmonth");
        type("byear", "aday", "amonth");
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("new_group")).click();
    }

    public void initGroupHeader(String title, String company, String address, String home) {
        type(title, company, address);
        wd.findElement(By.name(home)).click();
    }

    public void initGroupName(String firstname, String middlename, String lastname, String nickname) {
        type(firstname, middlename, lastname);
        wd.findElement(By.name(nickname)).click();
    }

    public void fillGroupForm(By add_new, By xpath) {
        wd.findElement(add_new).click();
        wd.findElement(xpath).click();
    }

    public void initGroupFooter(String email, String s, By xpath) {
        types(email, s);
        wd.findElement(xpath).click();
    }

    public void initGroupName() {
        types("firstname", "danil");
        types("middlename", "astapenko");
        wd.findElement(By.name("lastname")).click();
        types("firstname", "");
        types("middlename", "");
    }

    private void types(String firstname, String s) {
    }

    public void initGroupsMod2() {
        click(By.name("edit"));
    }

    private void click(By edit) {
    }

    public void submitGroupMod2() {
        click(By.name("updata"));
    }
}
