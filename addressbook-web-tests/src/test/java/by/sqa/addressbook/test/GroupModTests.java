package by.sqa.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupModTests extends TestBase{

    @Test
    public void testGroupMod() {
        app.getGroupHelper().initGroups("GROUPS");
        app.getGroupHelper().deleteGroups(By.name("delete"));
        if (app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().initGroupsMod();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupMod();
        app.getGroupHelper().returnToGroupPage("group page");
    }
}
