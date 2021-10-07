package by.sqa.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testGroupDeletion2 extends TestBase2 {

    @Test
    public void testGroupCreationTests() throws Exception {
        fillGroupForm(By.linkText("ADD_NEW"), By.xpath("//div[@id='content']/form/input[2]"));
        initGroupName();
        initGroupFooter("email", "", By.xpath("//div[@id='content']/form/input[21]"));
        initLogout(By.linkText("LOGOUT"));
    }
}
