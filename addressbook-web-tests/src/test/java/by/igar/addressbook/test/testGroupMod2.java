package by.igar.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testGroupMod2 extends TestBase2 {

    @Test
    public void testGroupMod2() {
        if (! app2.getGroupHelper2().isThereAGroup()) {
            app2.getGroupHelper2().createGroup(new GroupData("test1", null, null));
        }
        app2.getGroupHelper2().fillGroupForm(By.linkText("ADD_NEW"), By.xpath("//div[@id='content']/form/input[2]"));
        app2.getGroupHelper2().initGroupName();
        app2.getGroupHelper2().submitGroupMod2();
        app2.getGroupHelper2().returnToGroupPage("group page");
    }
}
