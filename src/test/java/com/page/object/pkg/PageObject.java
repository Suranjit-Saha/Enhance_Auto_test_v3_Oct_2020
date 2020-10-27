package com.page.object.pkg;

import com.utilities.pkg.ExplicitWait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    private WebDriver driver;
    private ExplicitWait expWait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        expWait = new ExplicitWait(driver);
    }

    public void clickMotorTab () {
        WebElement motorTab = expWait.findActiveElement(By.id("SearchTabs1_MotorsLink"),5);
        motorTab.click();
    }

    public void clickCarForSale () {
        WebElement carForSale = expWait.findActiveElement(By.linkText("Cars for sale"),5);
        carForSale.click();
    }

    public void clickUsedCar () throws InterruptedException {
        WebElement usedCar = expWait.findActiveElement(By.xpath("//div[@data-listing-id='2149202005']"),5);
        usedCar.click();
    }

    public void testAttributes (String attribute) {
        WebElement attElement = expWait.findActiveElement(By.xpath("//div[@class='key-details-attribute-label']//label[text()='" + attribute + "']"),5);
        Assert.assertEquals("Test that the attribute is displayed",attElement.isDisplayed(),true);
    }

}
