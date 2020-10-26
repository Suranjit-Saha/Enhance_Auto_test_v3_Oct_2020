package com.glue.code.pkg;

import com.page.object.pkg.PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefUI {
    private static String url = "https://www.tmsandbox.co.nz/" ;
    private static WebDriver driver = new ChromeDriver();
    private PageObject pageObject = new PageObject(driver);


    @Given("^User is on Used Car listing Page$")
    public void user_is_on_Used_Car_listing_Page()  {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(url);
        pageObject.clickMotorTab();
    }

    @When("^User queries an existing Used Car from the listing$")
    public void user_queries_an_existing_Used_Car_from_the_listing() throws InterruptedException {
        pageObject.clickCarForSale();
        pageObject.clickUsedCar();
    }

    @Then("^The Number plate is displayed$")
    public void the_Number_plate_is_displayed() throws InterruptedException {
        pageObject.testNumberPlate();
    }

    @Then("^The Kilometres is displayed$")
    public void the_Kilometres_is_displayed() {
        pageObject.testKilometres();
    }

    @Then("^The Body is displayed$")
    public void the_Body_is_displayed() {
        pageObject.testBody();
    }

    @Then("^The Seats are displayed$")
    public void the_Seats_are_displayed() {
        pageObject.testSeats();
        driver.quit();
    }

}
