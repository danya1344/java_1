package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModTests extends TestsBase {

    @BeforeMethod
    private void ensurePrecondition() {
        if (app.db().contacts().size() == 0) {
            app.getGoTo().add_NewPage();
            app.contact().create(new ContactDatas().withFirstname("daniil"));
        }
    }

    @Test
    public void testContactMod() {
        Contacts before = app.db().contacts();
        ContactDatas modifiedContact = before.iterator().next();
        ContactDatas contact = new ContactDatas()
                .withId(modifiedContact.getId()).withFirstname("daniil").withLastname("astapenko").withEmail("daniil.astapeno@gmail.ru").withGroup("test3");
        app.getGoTo().add_NewPage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
