package by.egar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelpers extends HelpersBase {

    public NavigationHelpers(WebDriver wd) {
        super(wd);
    }

    public void gotoAdd_NewPage() {
        click(By.linkText("ADD_NEW"));
    }
}
