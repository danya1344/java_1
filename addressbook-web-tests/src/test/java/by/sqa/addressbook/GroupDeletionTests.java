package by.sqa.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        initGroups("GROUPS");
        deleteGroups(By.name("delete"));
        returnToGroupPage("group page");
        initLogout("LOGOUT");
    }
}


