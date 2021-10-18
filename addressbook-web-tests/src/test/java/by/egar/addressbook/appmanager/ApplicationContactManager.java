package by.egar.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationContactManager {
    private final Properties properties;
    WebDriver wd;

    private NavigationHelpers goTo;
    private ContactHelpers contactHelpers;
    private SessionHelpers sessionHelpers;
    private String browser;

    public ApplicationContactManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resourses/%s.properties", target))));
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        contactHelpers = new ContactHelpers(wd);
        goTo = new NavigationHelpers(wd);
        sessionHelpers = new SessionHelpers(wd);
        sessionHelpers.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void stop() {
        wd.quit();
    }

    public ContactHelpers contact() {
        return contactHelpers;
    }

    public NavigationHelpers getGoTo() {
        return goTo;
    }
}
