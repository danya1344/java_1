package by.igar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper2 {
    protected WebDriver wd;

    public BaseHelper2(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(String address2, String phone2, String notes) {
        wd.findElement(By.name(address2)).click();
        wd.findElement(By.name(phone2)).click();
        wd.findElement(By.name(notes)).click();
    }

    private void extrac(String firstname, String danil) {
        wd.findElement(By.name(firstname)).click();
        wd.findElement(By.name(firstname)).clear();
        wd.findElement(By.name(firstname)).sendKeys(danil);
    }
}
