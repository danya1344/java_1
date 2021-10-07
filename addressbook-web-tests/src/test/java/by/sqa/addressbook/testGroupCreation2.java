package by.sqa.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testGroupCreation2 extends TestBase2 {

    @Test
    public void testGroupCreationTests() throws Exception {
        fillGroupForm();
        submitGroupCreation("submit");
        initLogout(By.linkText("LOGOUT"));
    }
}
