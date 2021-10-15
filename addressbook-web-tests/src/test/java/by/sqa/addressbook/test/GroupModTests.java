package by.sqa.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModTests extends TestBase{

    @Test
    public void testGroupMod() {
        app.getNavigationHelper().gotoGroupPage();
       // if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
       // List<GroupData> before = app.getGroupHelper().getGroupLict();
       // app.getGroupHelper().selectGroup(before.size() - 1);
       // app.getGroupHelper().initGroupsMod();
       // GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", "test2", "test3");
       // app.getGroupHelper().fillGroupForm(group);
       // app.getGroupHelper().submitGroupMod();
       // app.getGroupHelper().returnToGroupPage();
       // List<GroupData> after = app.getGroupHelper().getGroupLict();
      //  Assert.assertEquals(after.size(), before.size());

      //  before.remove(before.size() - 1);
       // before.add(group);
       // Comparable<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      //  before.sort(byId);
      //  after.sort(byId);
      //  Assert.assertEquals(before, after);

}
