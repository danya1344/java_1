package by.sqa.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getGroupHelper().initGroupCreation("new");
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupCreation("submit");
        app.getGroupHelper().returnToGroupPage("group page");
        app.initLogout("LOGOUT");
    }
}
