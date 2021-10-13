package by.egar.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestsBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelpers().gotoAdd_NewPage();
    app.getContactHelpers().selectContact();
    app.getContactHelpers().deleteSelectedContact();
    app.getNavigationHelpers().returnToHomePage();
  }
}

