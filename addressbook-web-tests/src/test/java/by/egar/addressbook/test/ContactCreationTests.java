package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestsBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getGoTo().add_NewPage();
        List<ContactDatas> before = app.contact().list();
        ContactDatas contact = new ContactDatas().withFirstname("daniil");
        app.contact().create(contact);
        List<ContactDatas> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(contact);
        Comparator<? super ContactDatas> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
