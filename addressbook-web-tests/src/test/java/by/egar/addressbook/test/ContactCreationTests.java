package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestsBase {

    @Test
    public void testContactCreation()  {
        app.getGoTo().add_NewPage();
        Contacts before = app.contact().all();
        ContactDatas contact = new ContactDatas().withFirstname("daniil");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
