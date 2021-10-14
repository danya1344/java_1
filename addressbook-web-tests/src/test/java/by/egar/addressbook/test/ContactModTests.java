package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModTests extends TestsBase {
    @Test
    public void testContactMod() {
        //app.getNavigationHelpers().gotoAdd_NewPage();
        if (! app.getContactHelpers().isThereContact()) {
            app.getContactHelpers().createContact(new ContactDatas("daniil", "astap", "daniil@qmail.ru", "test1"), true);
        }
        List<ContactDatas> before = app.getContactHelpers().getContactLint();
        app.getContactHelpers().selectContact(before.size() - 1);
        app.getContactHelpers().initContactMod();
        ContactDatas contact = new ContactDatas(before.get(before.size() - 1).getId(),"daniil", null, null, null);
        app.getContactHelpers().fillContactForm((contact), false);
        app.getContactHelpers().submitContactMod();
        app.getNavigationHelpers().returnToHomePage();
        List<ContactDatas> after = app.getContactHelpers().getContactLint();
        Assert.assertEquals(after.size(), before.size() - 1 );

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
