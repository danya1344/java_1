package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.annotations.Test;

public class ContactModTests extends TestsBase {
    @Test
    public void testContactMod() {
        //app.getNavigationHelpers().gotoAdd_NewPage();
        app.getContactHelpers().selectContact();
        app.getContactHelpers().initContactMod();
        app.getContactHelpers().fillContactForm(new ContactDatas("daniil", null, null, null), false);
        app.getContactHelpers().submitContactMod();
        app.getContactHelpers().returnToHomePage();
    }
}
