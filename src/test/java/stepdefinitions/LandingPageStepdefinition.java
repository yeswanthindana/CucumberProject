package stepdefinitions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.landingPageObjects;
import pageObjects.pageObjectManager;
import utilities.TestContextSetup;
import utilities.resuable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;


public class LandingPageStepdefinition {

    public WebDriver driver;
    public String proDName;
    public String prod;
    public TestContextSetup testContextSetup;
    pageObjectManager pom;

    public LandingPageStepdefinition(TestContextSetup testcontextsetup){
        this.testContextSetup = testcontextsetup;
    }

    @Given("user is on GreenKart main page")
    public void user_is_on_green_kart_main_page() throws IOException {
        testContextSetup.driver = testContextSetup.baseClass.globalDriver();
        testContextSetup.pom = new pageObjectManager(testContextSetup.driver);
        testContextSetup.reusable = new resuable(testContextSetup.driver);
        System.out.println("User is on the Greenkart Main Page");
    }

    @Given("Verify User is on the GreenKart Main Page")
    public void Verify_user_is_on_the_green_kart_main_page() {
        System.out.println(testContextSetup.driver.getTitle());
        Assert.assertEquals(testContextSetup.driver.getTitle(), "GreenKart - veg and fruits kart");
        System.out.println("Verified User is on the Greenkart Main Page");
    }


    @When("User searches with name {string}")
    public void user_searches_with_name(String string) throws InterruptedException {
   //     pom = new pageObjectManager(testContextSetup.driver);
        landingPageObjects lp = testContextSetup.pom.LandingPage();
      //  lp = new landingPageObjects(testContextSetup.driver);
        lp. enterProductNameinSearchBox(string);
        System.out.println("User searched for " + string);
        lp.clickSearchButton();
        Thread.sleep(10000);
    }


    @When("Extrcated name of the Product")
    public void extrcated_name_of_the_product() {
 //       pom = new pageObjectManager(testContextSetup.driver);
        landingPageObjects lp = testContextSetup.pom.LandingPage();
        testContextSetup.prod = lp.extractName();
        System.out.println("Extracted product name: " + testContextSetup.prod);
    }



}
