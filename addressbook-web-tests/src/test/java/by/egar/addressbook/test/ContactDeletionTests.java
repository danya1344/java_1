package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestsBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelpers().gotoAdd_NewPage();
    if (! app.getContactHelpers().isThereContact()) {
      app.getContactHelpers().createContact(new ContactDatas("id","daniil", "astap", "daniil@qmail.ru", "test1"), true);
    }
    List<ContactDatas> before = app.getContactHelpers().getContactLint();
    app.getContactHelpers().selectContact(before.size() - 1);
    app.getContactHelpers().deleteSelectedContact();
    app.getNavigationHelpers().returnToHomePage();
    List<ContactDatas> after = app.getContactHelpers().getContactLint();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}

