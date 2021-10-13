package by.egar.addressbook.appmanager;

import by.egar.addressbook.model.ContactDatas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelpers extends HelpersBase {

    public ContactHelpers(WebDriver wd) {
        super(wd);
    }


    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactDatas contactDatas, boolean creation) {
        type(By.name("firstname"), contactDatas.firstname());
        type(By.name("lastname"), contactDatas.lastname());
        type(By.name("email"), contactDatas.email());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDatas.group());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='DELETE']"));
        click(By.name("delete"));
        click(By.xpath("Delete 1 addresses?: "));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initContactMod() {
        click(By.xpath("//img[@alt='EDIT']"));
    }

    public void submitContactMod() {
        click(By.name("update"));
    }


    public void createContact(ContactDatas contact, boolean b) {
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void fillContactForm(ContactDatas contact) {
    }

    private void returnToHomePage() {
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
