package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.resuable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class productStepdefinitions extends resuable {

    //Initialize WebDriver
    public WebDriver driver;
    public static String proDName;
    public static String prod;


    @Given("user is on GreenKart main page")
    public void user_is_on_green_kart_main_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    //Verify User is on the GreenKart Main Page
    @Given("Verify User is on the GreenKart Main Page")
    public void Verify_user_is_on_the_green_kart_main_page() {

        print(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");
    }
    @When("User searches with name {string}")
    public void user_searches_with_name(String string) {

        driver.findElement(By.cssSelector("input[class='search-keyword']")).sendKeys(string);
        print("User searched for " + string);
        driver.findElement(By.cssSelector("button[class='search-button']")).click();

    }
    @When("Extrcated name of the Product")
    public void extrcated_name_of_the_product() {

        prod = driver.findElement(By.xpath("//h4")).getText().split("-")[0].trim();
        print("Extracted product name: " + prod);
    }



    @Then("User searched for name {string} in offers to validate if product is available")
    public void user_searched_for_name_in_offers_to_validate_if_product_is_available(String string) throws InterruptedException {



        driver.findElement(By.xpath("//a[text()='Top Deals']")).click();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        for (String handle : handles){
            driver.switchTo().window(handle);
            print(driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains("Offers"))
            {
            print("Switched to Offers page");
                break;
            }

        }





        List<WebElement> prod = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
        boolean found = false;
        for(WebElement pr : prod){

            String prodName = pr.getText().substring(0,3);
            proDName = pr.getText();
            print("Product name in offers: " + prodName);
            if(prodName.equalsIgnoreCase(string)){
                print("Product " + string + " is available in offers");
                found = true;
                break;
            } else {
                print("Product " + string + " is not available in offers");
            }
        }
        Assert.assertTrue(found);

    }

    @Then("validate name in home page and offers page are same")
    public void assertProd(){
        Assert.assertEquals(prod,proDName);
        print(prod + "    " + proDName);
        driver.quit();
    }

}
