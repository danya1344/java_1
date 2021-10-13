package by.egar.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationContactManager {

    private WebDriver wd;

    private NavigationHelpers navigationHelpers;
    private ContactHelpers contactHelpers;
    private SessionHelpers sessionHelpers;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        contactHelpers = new ContactHelpers(wd);
        navigationHelpers = new NavigationHelpers(wd);
        sessionHelpers = new SessionHelpers(wd);
        sessionHelpers.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public ContactHelpers getContactHelpers() {
        return contactHelpers;
    }

    public NavigationHelpers getNavigationHelpers() {
        return navigationHelpers;
    }
}
