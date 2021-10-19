package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestsBase {

  @BeforeMethod
  private void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.getGoTo().add_NewPage();
      app.contact().create(new ContactDatas().withFirstname("daniil"));
    }
  }
  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactDatas deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }
}

