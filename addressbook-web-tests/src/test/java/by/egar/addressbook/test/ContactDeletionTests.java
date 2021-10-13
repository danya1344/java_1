package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestsBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelpers().gotoAdd_NewPage();
    if (! app.getContactHelpers().isThereContact()) {
      app.getContactHelpers().createContact(new ContactDatas("daniil", "astap", "daniil@qmail.ru", "test1"), true);
    }
    app.getContactHelpers().selectContact();
    app.getContactHelpers().deleteSelectedContact();
    app.getNavigationHelpers().returnToHomePage();
  }
}

