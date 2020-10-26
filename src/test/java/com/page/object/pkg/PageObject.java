package com.page.object.pkg;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "SearchTabs1_MotorsLink")
    private WebElement motorTab;

    @FindBy(linkText = "Cars for sale")
    private WebElement carForSale;

    @FindBy(xpath = "//div[@data-listing-id='2149202005']")
    private WebElement usedCar;

    public void clickMotorTab () {
        motorTab.click();
    }

    public void clickCarForSale () throws InterruptedException {
        Thread.sleep(1000);
        carForSale.click();
    }

    public void clickUsedCar () throws InterruptedException {
        Thread.sleep(1000);
        usedCar.click();
    }

    public void testNumberPlate() throws InterruptedException {
        Thread.sleep(1000);
        WebElement numberPlate = driver.findElement(By.xpath("//div[@class='key-details-attribute-label']//label[text()='Number plate']"));
        Assert.assertEquals("Test that the number palate is displayed",numberPlate.isDisplayed(),true);
    }

    public void testKilometres() {
        WebElement numberPlate = driver.findElement(By.xpath("//div[@class='key-details-attribute-label']//label[text()='Kilometres']"));
        Assert.assertEquals("Test that the kilometers are displayed",numberPlate.isDisplayed(),true);
    }

    public void testBody()  {
        WebElement numberPlate = driver.findElement(By.xpath("//div[@class='key-details-attribute-label']//label[text()='Body']"));
        Assert.assertEquals("Test that the body is displayed",numberPlate.isDisplayed(),true);
    }

    public void testSeats ()  {
        WebElement numberPlate = driver.findElement(By.xpath("//div[@class='key-details-attribute-label']//label[text()='Seats']"));
        Assert.assertEquals("Test that the seats are displayed",numberPlate.isDisplayed(),true);
    }

}
