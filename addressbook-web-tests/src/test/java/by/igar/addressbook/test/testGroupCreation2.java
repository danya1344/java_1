package by.igar.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class testGroupCreation2 extends TestBase2 {

    @Test
    public void testGroupCreationTests() throws Exception {
        app2.getGroupHelper2().createGroup(new GroupData("test1", null, null));
    }
}
