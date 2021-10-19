package by.egar.addressbook.test;

import by.egar.addressbook.appmanager.ApplicationContactManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class TestsBase {

    Logger logger = (Logger) LoggerFactory.getLogger(TestsBase.class);

    protected static final ApplicationContactManager app
            = new ApplicationContactManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test" + m.getName() + "with parameters" + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test" + m.getName());
    }
}
