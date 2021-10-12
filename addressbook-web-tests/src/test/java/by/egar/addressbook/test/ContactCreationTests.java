package by.egar.addressbook.test;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoAdd_NewPage();
    fillContactForm(new ContactData("daniil", "astap", "daniil@qmail.ru"));
    submitContactCreation();
    returnToHomePage();
  }
}
