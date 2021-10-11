package by.igar.addressbook.test;

import by.igar.addressbook.appmanager.ApplicationManager2;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase2 {

    protected final ApplicationManager2 app2 = new ApplicationManager2(BrowserType.FIREFOX);

    @BeforeMethod
    public void seUp() throws Exception {
        app2.init();
    }

    @AfterMethod
    public void tearDown() {
        app2.stop();
    }
}

