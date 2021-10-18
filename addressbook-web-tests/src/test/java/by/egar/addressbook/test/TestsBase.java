package by.egar.addressbook.test;

import by.egar.addressbook.appmanager.ApplicationContactManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestsBase {

    protected static final ApplicationContactManager app
            = new ApplicationContactManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
