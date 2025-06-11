package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingPageObjects {

    // Initilaize Driver
    public WebDriver driver;

    //Driver Constructor
    public landingPageObjects(WebDriver driver){
        this.driver = driver;
    }

       private By searchbox = By.cssSelector("input[class='search-keyword']");
       private By searchButton = By.cssSelector("button[class='search-button']");
       private By extractName = By.xpath("//h4");

       public void enterProductNameinSearchBox(String string) {
           driver.findElement(searchbox).sendKeys(string);
       }

       public void clickSearchButton() {
           driver.findElement(searchButton).click();
       }

       public String extractName(){
           String ep = driver.findElement(extractName).getText().split("-")[0].trim();
           return ep;
       }
}
