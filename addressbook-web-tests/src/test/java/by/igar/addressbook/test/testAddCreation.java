package by.igar.addressbook.test;

import by.igar.addressbook.model.AddData;
import org.testng.annotations.Test;

public class testAddCreation extends TestBase2 {

    @Test
    public void testAddCreation()  {
        app2.getNavigationHelper2().gotoHomePage();
        app2.getAddHelper().initAddNewCreation();
        app2.getAddHelper().fillAddNewForm(new AddData("daniil", "astapenko", "danill.astapenko@gmail.com"));
        app2.getAddHelper().returnToHomePage();
    }
}
