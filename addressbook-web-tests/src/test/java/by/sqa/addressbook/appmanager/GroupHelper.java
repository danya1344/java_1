package by.sqa.addressbook.appmanager;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage(String s) {
        wd.findElement(By.linkText(s)).click();
    }

    public void submitGroupCreation(String submit) {
        wd.findElement(By.name(submit)).click();
    }

    public void fillGroupForm(GroupData groupData) {
        type("group_name", By.name("group_name"), groupData.name());
        type(null, By.name("group_header"), groupData.header());
        type(null, By.name("group_footer"), groupData.footer());
    }


    public void initGroupCreation(String s) {
        wd.findElement(By.name(s)).click();
    }

    public void deleteGroups(By delete) {
        wd.findElement(delete).click();
    }

    public void initGroups(String groups) {
        wd.findElement(By.linkText(groups)).click();
    }

    public void initGroupsMod() {
        click(By.name("edit"));
    }

    private void click(By edit) {
    }

    public void submitGroupMod() {
        click(By.name("updata"));
    }
}
