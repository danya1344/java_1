package by.sqa.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
    private WebDriver wd;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        login("user", "admin", "pass", "secret", By.xpath("//input[@value='LOGIN']"));
    }

    private void login(String user, String admin, String pass, String secret, By xpath) {
        wd.findElement(By.name(user)).clear();
        wd.findElement(By.name(user)).sendKeys(admin);
        wd.findElement(By.name(pass)).click();
        wd.findElement(By.name(pass)).clear();
        wd.findElement(By.name(pass)).sendKeys(secret);
        wd.findElement(xpath).click();
    }

    @Test
    public void testGroupCreation() {
        initGroupCreation("new");
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation("submit");
        returnToGroupPage("group page");
        initLogout("LOGOUT");
    }

    private void initLogout(String logout) {
        wd.findElement(By.linkText(logout)).click();
    }

    private void returnToGroupPage(String s) {
        wd.findElement(By.linkText(s)).click();
    }

    private void submitGroupCreation(String submit) {
        wd.findElement(By.name(submit)).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.name());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.header());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    private void initGroupCreation(String s) {
        wd.findElement(By.name(s)).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        wd.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
