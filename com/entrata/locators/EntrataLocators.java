package com.entrata.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntrataLocators {

    // By watchDemo  = By.xpath( "//div[@class='main-header-grid']//a[@class='button-default solid-dark-button']");
    @FindBy(xpath = "//div[@class='main-header-grid']//a[@class='button-default solid-dark-button']")
    WebElement watchDemo;

    public void clickWatchDemo() {
        watchDemo.click();
    }

    @FindBy(id = "FirstName")
    WebElement firstName;

    public void setFirstName(String name) {
        firstName.sendKeys(name);
    }

    @FindBy(id = "LastName")
    WebElement lastName;

    public void setlasttName(String lName) {
        lastName.sendKeys(lName);
    }

    @FindBy(id = "Email")
    WebElement email;

    public void setemail(String Email) {
        email.sendKeys(Email);
    }

    @FindBy(id = "Phone")
    WebElement phone;

    public void setPhone(String phone1) {
        phone.sendKeys(phone1);
    }

    @FindBy(id = "Company")
    WebElement company;

    public void setcompany(String company1) {
        company.sendKeys(company1);
    }


    @FindBy(id = "Unit_Count__c")
    public WebElement Ucount;
    public void selectUnitCountByValue(String value) {
        Select dropdown = new Select(Ucount);
        dropdown.selectByValue(value);
    }

  //  @FindBy(css="a[href*='basecamp']") WebElement basecamp;
@FindBy(linkText = "Base Camp")   WebElement basecamp;
    public void clickBaseCamp() {
        basecamp.click();
         }

    public EntrataLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
