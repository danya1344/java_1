package by.sqa.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        app.getGroupHelper().initGroups("GROUPS");
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().deleteGroups(By.name("delete"));
        app.getGroupHelper().returnToGroupPage("group page");
        app.initLogout("LOGOUT");
    }
}


