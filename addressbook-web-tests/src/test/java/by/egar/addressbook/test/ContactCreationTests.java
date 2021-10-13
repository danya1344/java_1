package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelpers().gotoAdd_NewPage();
    app.getContactHelpers().fillContactForm(new ContactData("daniil", "astap", "daniil@qmail.ru"));
    app.getContactHelpers().submitContactCreation();
    app.getContactHelpers().returnToHomePage();
  }
}
