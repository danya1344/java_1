package by.igar.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testGroupCreation2 extends TestBase2 {

    @Test
    public void testGroupCreationTests() throws Exception {
        app2.getGroupHelper2().fillGroupForm(new GroupData("test1", null, null));
        app2.getGroupHelper2().submitGroupCreation("submit");
        app2.initLogout(By.linkText("LOGOUT"));
    }
}
