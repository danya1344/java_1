package by.egar.addressbook.test;

import by.egar.addressbook.model.ContactDatas;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestsBase {

  @BeforeMethod
  private void ensurePrecondition() {
    app.getGoTo().add_NewPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactDatas().withFirstname("daniil"));
  }
  }
  @Test
  public void testContactDeletion() throws Exception {
    List<ContactDatas> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactDatas> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}

