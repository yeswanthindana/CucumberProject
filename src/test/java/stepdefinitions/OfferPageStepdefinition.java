package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.OfferPageObjects;
import utilities.TestContextSetup;
import utilities.resuable;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OfferPageStepdefinition{
    TestContextSetup testContextSetup;

    public OfferPageStepdefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    public String proDName;

    @Then("^User searched for name (.+) in offers to validate if product is available$")
    public void user_searched_for_name_in_offers_to_validate_if_product_is_available(String string) throws InterruptedException {
        switchToOffersPage();
        OfferPageObjects op = testContextSetup.pom.offerPage();
        List<WebElement> prod = op.grabProductName();
        boolean found = false;
        for(WebElement pr : prod){
            String prodName = pr.getText().substring(0,3);
            proDName = pr.getText();
            System.out.println("Product name in offers: " + prodName);
            if(prodName.equalsIgnoreCase(string)){
                System.out.println("Product " + string + " is available in offers");
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    public void switchToOffersPage(){
        OfferPageObjects op = testContextSetup.pom.offerPage();
        op.clickTopDeals();
        System.out.println("Switching to Offers Page");
        testContextSetup.reusable.switchToOffersPage();
    }

    @Then("validate name in home page and offers page are same")
    public void assertProd(){
        Assert.assertEquals(testContextSetup.prod,proDName);
        System.out.println(testContextSetup.prod + "    " + proDName);
        testContextSetup.driver.quit();
    }

}
