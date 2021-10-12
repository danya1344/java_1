package by.igar.addressbook.test;

import by.igar.addressbook.model.AddData;
import org.testng.annotations.Test;

public class testAddMod extends TestBase2 {

    @Test
    public void testGroupMod2() {
        app2.getNavigationHelper2().gotoHomePage();
        app2.getAddHelper().conectIdAdd();
        app2.getAddHelper().initAddMod();
        app2.getAddHelper().fillAddNewForm(new AddData(null, null, null));
        app2.getAddHelper().submitAddMod();
        app2.getAddHelper().returnToHomePage();
    }
}
