package by.sqa.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        //List<GroupData> before = app.getGroupHelper().getGroupLict();
        GroupData group = new GroupData("test1", null, null);
        app.getGroupHelper().createGroup(group);
        //List<GroupData> after = app.getGroupHelper().getGroupLict();
        //Assert.assertEquals(after.size(), before.size() + 1);

        //before.add(group);
       // Comparable<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
       // before.sort(byId);
       // after.sort(byId);
       // Assert.assertEquals(before, after);
    }
}
