package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModTests extends TestsBase {
    @Test
    public void testContactMod() {
        //app.getNavigationHelpers().gotoAdd_NewPage();
        app.getContactHelpers().selectContact();
        app.getContactHelpers().initContactMod();
        app.getContactHelpers().fillContactForm(new ContactData("daniil", null, null));
        app.getContactHelpers().submitContactMod();
        app.getContactHelpers().returnToHomePage();
    }
}
