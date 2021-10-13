package by.egar.addressbook.appmanager;

import by.egar.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelpers  extends HelpersBase{

    public ContactHelpers(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstname());
        type(By.name("lastname"), contactData.lastname());
        type(By.name("email"), contactData.email());
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='DELETE']"));
        click(By.name("delete"));
        click(By.xpath("Delete 1 addresses?: "));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactMod() {
        click(By.xpath("//img[@alt='EDIT']"));
    }

    public void submitContactMod() {
        click(By.name("update"));
    }
}
