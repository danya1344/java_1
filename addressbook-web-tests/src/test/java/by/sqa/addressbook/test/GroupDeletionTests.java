package by.sqa.addressbook.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        app.getGroupHelper().initGroups("GROUPS");
        app.getGroupHelper().deleteGroups(By.name("delete"));
        app.getGroupHelper().returnToGroupPage("group page");
        app.initLogout("LOGOUT");
    }
}


