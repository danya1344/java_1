package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestsBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line !=null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactDatas.class);
            List<ContactDatas> contacts = (List<ContactDatas>) xstream.fromXML(xml);
            return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactDatas contact) {
        File photo = new File("src/test/resourses/pngwing.png");
        ContactDatas contacts = new ContactDatas().withPhoto(photo);
        if (app.db().contacts().size() == 0) {
            app.getGoTo().add_NewPage();
            Contacts before = app.db().contacts();
            app.contact().create(contact);
            assertThat(app.contact().count(), equalTo(before.size() + 1));
            Contacts after = app.db().contacts();
            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
            verifyContactListInUI();
        }
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

