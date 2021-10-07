package by.igar.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper2 extends BaseHelper2 {

    public ContactHelper2(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String passsword) {
        type(By.name("user"), username);
        type(By.name("pass"), passsword);
        click(By.xpath("//input[@value='LOGIN']"));
    }

    private void click(By xpath) {
    }

    private void type(By user, String username) {
    }
}

