package by.egar.addressbook.appmanager;

import by.egar.addressbook.model.ContactDatas;
import by.egar.addressbook.model.Contacts;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactHelpers extends HelpersBase {

    private int index;
    private JavaIOFileDescriptorAccess sells;

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
        attach(By.name("photo"), contactDatas.getPhoto());

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
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactDatas contact) {
        selectContactById(contact.getId());
        initContactMod();
        fillContactForm(contact, false);
        submitContactMod();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactDatas contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
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

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void create(ContactDatas contact) {
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = sells.get(1).getText();
            String firstname = sells.get(2).getText();
            String allPhones = sells.get(5).getText();
            String allEmail = sells.get(4).getText();
            String address = sells.get(3).getText();
            contactCache.add(new ContactDatas().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones).withAllEmails(allEmail).withAddress(address));
        }
        return new Contacts(contactCache);
    }

    public ContactDatas infoFromEditForm(ContactDatas contact) {
        initContactModById(contact.getId());
        String firstname = wd.findElements(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElements(By.name("lastname")).getAttribute("value");
        String home = wd.findElements(By.name("home")).getAttribute("value");
        String mobile = wd.findElements(By.name("mobile")).getAttribute("value");
        String work = wd.findElements(By.name("work")).getAttribute("value");
        String email = wd.findElements(By.name("email")).getAttribute("value");
        String email2 = wd.findElements(By.name("email2")).getAttribute("value");
        String email3 = wd.findElements(By.name("email3")).getAttribute("value");
        String address = wd.findElements(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactDatas().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
    }

    private void initContactModById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='&s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
