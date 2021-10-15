package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModTests extends TestsBase {

    @BeforeMethod
    private void ensurePrecondition() {
        //app.getGoTo().add_NewPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactDatas().withFirstname("daniil"));
        }
    }

    @Test
    public void testContactMod() {
        Contacts before = app.contact().all();
        ContactDatas modifiedContact = before.iterator().next();
        ContactDatas contact = new ContactDatas()
                .withId(modifiedContact.getId()).withFirstname("daniil").withLastname("astapenko").withEmail("daniil.astapeno@gmail.ru").withGroup("test3");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
