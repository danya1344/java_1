package by.igar.addressbook.appmanager;

import by.igar.addressbook.model.AddData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddHelper extends BaseHelper2 {

    private boolean acceptNextAlert;

    public AddHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void conectIdAdd() {
        click(By.id("2"));
        acceptNextAlert = true;
    }

    public void fillAddNewForm(AddData addData) {
        type(By.name("firstname_name"), addData.getName());
        type(By.name("lastname_header"), addData.getHeadar());
        type(By.name("email_footer"), addData.getFooter());
    }

    public void initAddNewCreation() {
        click(By.linkText("ADD_NEW"));
    }

    public void deleteAddGroups() {
        click(By.xpath("//input[@value='DELETE']"));
        Assert.assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    private String closeAlertAndGetItsText() {
        return null;
    }

    public void initAddMod() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    }

    public void submitAddMod() {
        click(By.name("update"));
    }
}
