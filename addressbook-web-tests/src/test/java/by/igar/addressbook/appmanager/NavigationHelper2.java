package by.igar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper2 extends BaseHelper2  {

    public NavigationHelper2(WebDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {

        click(By.name("ADD_NEW"));
    }
}
