package by.sqa.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase2 {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/edit.php");
        login("admin", "secret");
    }

    private void login(String username, String passsword) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(passsword);
        wd.findElement(By.xpath("//input[@value='LOGIN']")).click();
        wd.findElement(By.xpath("//div[@id='content']/form/input[2]")).click();
    }

    protected void initLogout(By logout) {
        wd.findElement(logout).click();
    }

    protected void submitGroupCreation(String submit) {
        wd.findElement(By.name(submit)).click();
    }

    protected void fillGroupForm() {
        initGroupName("firstname", "middlename", "lastname", "nickname");
        initGroupHeader("title", "company", "address", "home");
        initGroupFooter();
        initGroupID("address2", "phone2", "notes");
    }

    private void initGroupID(String address2, String phone2, String notes) {
        wd.findElement(By.name(address2)).click();
        wd.findElement(By.name(phone2)).click();
        wd.findElement(By.name(notes)).click();
    }

    private void initGroupFooter() {
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("bday")).click();
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("aday")).click();
        wd.findElement(By.name("amonth")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("new_group")).click();
    }

    private void initGroupHeader(String title, String company, String address, String home) {
        wd.findElement(By.name(title)).click();
        wd.findElement(By.name(company)).click();
        wd.findElement(By.name(address)).click();
        wd.findElement(By.name(home)).click();
    }

    private void initGroupName(String firstname, String middlename, String lastname, String nickname) {
        wd.findElement(By.name(firstname)).click();
        wd.findElement(By.name(middlename)).click();
        wd.findElement(By.name(lastname)).click();
        wd.findElement(By.name(nickname)).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
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

    protected void fillGroupForm(By add_new, By xpath) {
        wd.findElement(add_new).click();
        wd.findElement(xpath).click();
    }

    protected void initGroupFooter(String email, String s, By xpath) {
        wd.findElement(By.name(email)).click();
        wd.findElement(By.name(email)).clear();
        wd.findElement(By.name(email)).sendKeys(s);
        wd.findElement(xpath).click();
    }

    protected void initGroupName() {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("danil");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("astapenko");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("");
    }
}
