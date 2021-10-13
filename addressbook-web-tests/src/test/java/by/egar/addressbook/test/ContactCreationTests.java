package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelpers().gotoAdd_NewPage();
    List<ContactDatas> before = app.getContactHelpers().getContactLint();
    app.getContactHelpers().createContact(new ContactDatas("daniil", "astapenko", "daniil.astapenko@gmail.ru", "test3"), true);
    List<ContactDatas> after = app.getContactHelpers().getContactLint();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
