package by.igar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager2 {

    protected WebDriver wd;

    private ContactHelper2 contactHelper2;
    private NavigationHelper2 navigationHelper2;
    private GroupHelper2 groupHelper2;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/edit.php");
        groupHelper2 = new GroupHelper2(wd);
        navigationHelper2 = new NavigationHelper2(wd);
        contactHelper2 = new ContactHelper2(wd);
        contactHelper2.login("admin", "secret");
    }

    public void initLogout(By logout) {
        wd.findElement(logout).click();
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper2 getGroupHelper2() {
        return groupHelper2;
    }

    public NavigationHelper2 getNavigationHelper2() {
        return navigationHelper2;
    }
}
