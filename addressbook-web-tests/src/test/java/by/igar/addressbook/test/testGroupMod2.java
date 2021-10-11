package by.igar.addressbook.test;

import by.igar.addressbook.model.GroupData2;
import org.testng.annotations.Test;

public class testGroupMod2 extends TestBase2 {

    @Test
    public void testGroupMod2() {
        app2.getNavigationHelper2().gotoGroupPage();
        app2.getGroupHelper2().selectGroup();
        app2.getGroupHelper2().initGroupMod();
        app2.getGroupHelper2().fillGroupForm(new GroupData2("test_name", "test_surname", null));
        app2.getGroupHelper2().submitGroupMod();
        app2.getGroupHelper2().returnToGroupPage();
    }
}
