package by.igar.addressbook.test;

import org.testng.annotations.Test;

public class testGroupDeletion2 extends TestBase2 {
    @Test
    public void testGroupDeletion() {
        app2.getNavigationHelper2().gotoGroupPage();
        app2.getGroupHelper2().selectGroup();
        app2.getGroupHelper2().deleteSelectedGroups();
        app2.getGroupHelper2().returnToGroupPage();
    }
}
