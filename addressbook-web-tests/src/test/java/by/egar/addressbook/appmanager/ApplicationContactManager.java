package by.egar.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationContactManager {

    WebDriver wd;

    private NavigationHelpers navigationHelpers;
    private ContactHelpers contactHelpers;
    private SessionHelpers sessionHelpers;
    private String browser;

    public ApplicationContactManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        if (browser.equals( BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }
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
