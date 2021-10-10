package by.igar.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testGroupDeletion2 extends TestBase2 {

    @Test
    public void testGroupCreationTests() throws Exception {
        if (! app2.getGroupHelper2().isThereAGroup()) {
            app2.getGroupHelper2().createGroup(new GroupData("test1", null, null));
        }
        app2.getGroupHelper2().fillGroupForm(By.linkText("ADD_NEW"), By.xpath("//div[@id='content']/form/input[2]"));
        app2.getGroupHelper2().initGroupName();
        app2.getGroupHelper2().initGroupFooter("email", "", By.xpath("//div[@id='content']/form/input[21]"));
        app2.getGroupHelper2().returnToGroupPage("group page");
        app2.initLogout(By.linkText("LOGOUT"));
    }
}
