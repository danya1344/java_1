package by.igar.addressbook.test;

import by.igar.addressbook.appmanager.ApplicationManager2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase2 {

    protected final ApplicationManager2 app2 = new ApplicationManager2();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        app2.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app2.stop();
    }

}
