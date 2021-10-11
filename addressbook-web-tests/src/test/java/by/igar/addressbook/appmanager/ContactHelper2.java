package by.igar.addressbook.appmanager;

import by.igar.addressbook.model.ContactData2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper2 extends BaseHelper2 {

    public ContactHelper2(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData2) {
        type(By.name("firstname")), contactData.getFirstname());
        type(By.name("lastname")), contactData.getLastname());
    }
    public void sumbitContactCreation() { click(By.name("sumbit")); }
    
}

