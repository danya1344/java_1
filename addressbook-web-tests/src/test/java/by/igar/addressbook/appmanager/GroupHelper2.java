package by.igar.addressbook.appmanager;

import by.igar.addressbook.model.GroupData2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper2 extends BaseHelper2 {

    public GroupHelper2(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData2 groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeadar());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupMod() {
        click(By.name("edit"));
    }

    public void submitGroupMod() {
        click(By.name("update"));
    }
}
