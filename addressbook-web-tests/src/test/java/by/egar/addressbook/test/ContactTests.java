package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTests extends TestsBase {

    @Test
    public void testContact() {
        app.getGoTo().add_NewPage();
        ContactDatas contact = app.contact().all().iterator().next();
        ContactDatas contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getFirstname(), equalTo(mergeFirstname(contactInfoFromEditForm)));
        assertThat(contact.getLastname(), equalTo(mergeLastaname(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeFirstname(ContactDatas contact) {
        return Arrays.asList(contact.getFirstname())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeLastaname(ContactDatas contact) {
        return Arrays.asList(contact.getLastname())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactDatas contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactDatas contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }
        public static String cleaned(String phone) {
            return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
        }

    private String mergeAddress(ContactDatas contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
