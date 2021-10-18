package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestsBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/contacts.csv")));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(";");
            list.add(new Object[] {new ContactDatas().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactDatas contact) {
        File photo = new File("src/test/resourses/pngwing.png");
        ContactDatas contact = new ContactDatas().withPhoto(photo);
        app.getGoTo().add_NewPage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadContactCreation() {
        app.getGoTo().add_NewPage();
        Contacts before = app.contact().all();
        ContactDatas contact = new ContactDatas().withFirstname("daniil");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}

