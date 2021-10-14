package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestsBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelpers().gotoAdd_NewPage();
        List<ContactDatas> before = app.getContactHelpers().getContactLint();
        ContactDatas contact = new ContactDatas("daniil", "astapenko", "daniil.astapenko@gmail.ru", "test3");
        app.getContactHelpers().createContact((contact), true);
        List<ContactDatas> after = app.getContactHelpers().getContactLint();
        Assert.assertEquals(after.size(), before.size() + 1);


        int max = 0;
        for (ContactDatas c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        before.add(contact);
        Comparator<? super ContactDatas> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
