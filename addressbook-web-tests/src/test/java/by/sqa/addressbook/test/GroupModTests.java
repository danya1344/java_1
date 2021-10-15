package by.sqa.addressbook.test;

import by.egar.addressbook.model.Contacts;
import by.sqa.addressbook.model.GroupData;
import by.sqa.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

;

public class GroupModTests extends TestBase{

    @BeforeMethod
        private void ensurePrecondition() {
            app.getGoTo().groupPage();
            if (app.group().all().size() == 0) {
                app.group().create(new GroupData().withName("test2"));
            }
        }

        @Test
        public void testContactMod() {
            Groups before = app.group().all();
            GroupData modifiedGroup = before.iterator().next();
            GroupData group = new GroupData()
                    .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
            app.group().modify(group);
            Contacts after = app.group().all();
            assertEquals(after.size(), before.size());
            assertThat(after, equalTo(before.without(modifiedGroups).withAdded(group)));
        }
    }

