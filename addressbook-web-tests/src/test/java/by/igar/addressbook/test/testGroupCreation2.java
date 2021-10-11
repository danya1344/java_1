package by.igar.addressbook.test;

import by.igar.addressbook.model.GroupData2;
import org.testng.annotations.Test;

public class testGroupCreation2 extends TestBase2 {

    @Test
    public void testGroupCreation()  {
        app2.getNavigationHelper2().gotoGroupPage();
        app2.getGroupHelper2().initGroupCreation();
        app2.getGroupHelper2().fillGroupForm(new GroupData2("test_name", "test_surname", "test1"));
        app2.getGroupHelper2().submitGroupCreation();
        app2.getGroupHelper2().returnToGroupPage();
    }
}
