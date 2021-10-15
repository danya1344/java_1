package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModTests extends TestsBase {

    @BeforeMethod
    private void ensurePrecondition() {
        //app.getGoTo().add_NewPage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactDatas().withFirstname("daniil"));
        }
    }

    @Test
    public void testContactMod() {
        List<ContactDatas> before = app.contact().list();
        int index = before.size() - 1;
        ContactDatas contact = new ContactDatas()
                .withId(before.get(index).getId()).withFirstname("daniil").withLastname("astapenko").withEmail("daniil.astapeno@gmail.ru").withGroup("test3");
        app.contact().modify(index, contact);
        List<ContactDatas> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactDatas> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}
