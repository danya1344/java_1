package by.sqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String user, String admin, String pass, String secret, By xpath) {
        type(By.name(user), admin);
        type(By.name(pass), secret);
        wd.findElement(xpath).click();
    }


    private void type(By name, String admin) {

    }
}
