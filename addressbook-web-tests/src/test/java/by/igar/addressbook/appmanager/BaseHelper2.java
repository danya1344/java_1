package by.igar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.awt.SystemColor.text;

public class BaseHelper2 {
    protected WebDriver wd;

    public BaseHelper2(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(String address2, String phone2, String notes) {
        String existingText = wd.findElement(By.name(address2)).getAttribute("value");
        if (!text.equals(existingText)) {
            wd.findElement(By.name(address2)).click();
            wd.findElement(By.name(phone2)).click();
            wd.findElement(By.name(notes)).click();
        }
    }

    protected void setWd(String name, String daniil) {
        String firstname = null;
        wd.findElement(By.name(firstname)).click();
        wd.findElement(By.name(firstname)).clear();
        wd.findElement(By.name(firstname)).sendKeys(daniil);
    }

    public void returnToGroupPage(String group_page) {

    }

    public void initGroups(String groups) {

    }

    public void deleteGroups(By delete) {

    }
}
