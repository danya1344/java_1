package by.egar.addressbook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactDeletionTests extends TestsBase {

  @Test
  public void testContactDeletion() throws Exception {
    gotoAdd_NewPage();
    selectContact();
    wd.findElement(By.xpath("//input[@value='DELETE']")).click();
    wd.findElement(By.name("delete")).click();
    wd.findElement(By.xpath("Delete 1 addresses?: ")).click();
    wd.findElement(By.name("[\\s]")).click();
    wd.findElement(By.linkText("HOME")).click();
  }

  private void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }
}

