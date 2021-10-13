package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelpers().getContactCount();
    app.getNavigationHelpers().gotoAdd_NewPage();
    app.getContactHelpers().createContact(new ContactDatas("daniil", "astap", "daniil@qmail.ru", "test1"), true);
    int after = app.getContactHelpers().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
