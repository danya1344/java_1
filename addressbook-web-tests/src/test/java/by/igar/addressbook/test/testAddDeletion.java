package by.igar.addressbook.test;

import org.testng.annotations.Test;

public class testAddDeletion extends TestBase2 {
    @Test
    public void testAddDeletion() {
        app2.getNavigationHelper2().gotoHomePage();
        app2.getAddHelper().conectIdAdd();
        app2.getAddHelper().deleteAddGroups();
        app2.getAddHelper().returnToHomePage();
    }
}
