package by.sqa.addressbook.appmanager;

import by.egar.addressbook.model.ContactDatas;
import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }


    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroups() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("select[]")).get(index).click();
    }

    public void initGroupsMod() {
        click(By.name("edit"));
    }

    public void submitGroupMod() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    private void modifyContact(int index, ContactDatas group) {
        selectGroup(index);
        initGroupsMod();
        //fillGroupForm(group);
        submitGroupMod();
        returnToGroupPage();
    }

    //public boolean isThereAGroup() { return isElementPresent(By.name("selected[]")); }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public List<ContactDatas> getContactLint() {
        List<ContactDatas> group = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //GroupData group = new GroupData(id, name, null, null);
            //group.add(group);

        }
        return group;
    }
}

