package by.sqa.addressbook.test;

import by.sqa.addressbook.model.GroupData;
import by.sqa.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    private void ensurePrecondition() {
        app.getGoTo().groupPage();
        if (app.groups().all().size() == 0) {
            app.groups().create(new GroupData().withName("test2"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedGroup)));
    }
}


