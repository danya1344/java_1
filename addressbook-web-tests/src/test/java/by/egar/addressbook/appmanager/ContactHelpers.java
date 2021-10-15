package by.egar.addressbook.appmanager;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactHelpers extends HelpersBase {

    private int index;

    public ContactHelpers(WebDriver wd) {
        super(wd);
    }


    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactDatas contactDatas, boolean creation) {
        type(By.name("firstname"), contactDatas.getFirstname());
        type(By.name("lastname"), contactDatas.getLastname());
        type(By.name("email"), contactDatas.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDatas.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='DELETE']"));
        click(By.name("delete"));
        click(By.xpath("Delete 1 addresses?: "));
        click(By.name("ok"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactMod() {
        click(By.xpath("//img[@alt='EDIT']"));
    }

    public void submitContactMod() {
        click(By.name("update"));
    }


    public void create(ContactDatas contact, boolean b) {
        gotoAdd_NewPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(ContactDatas contact) {
        selectContactById(contact.getId());
        initContactMod();
        fillContactForm(contact, false);
        submitContactMod();
        returnToHomePage();
    }

    public void delete(ContactDatas contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        returnToHomePage();
    }

    private void gotoAdd_NewPage() {
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

    public void create(ContactDatas contact) {
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactDatas().withId(id).withFirstname(name));

        }
        return contacts;
    }
}
