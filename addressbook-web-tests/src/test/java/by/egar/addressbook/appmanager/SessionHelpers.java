package by.egar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelpers extends HelpersBase {

    public SessionHelpers(WebDriver wd) {
        super(wd);
    }
    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='LOGIN']"));
    }
}
