package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class OfferPageObjects {

    public WebDriver driver;

    public OfferPageObjects(WebDriver driver){
        this.driver = driver;
    }

    private By topDeals = By.xpath("//a[text()='Top Deals']");
    private By productName = By.xpath("//table//tbody//tr//td[1]");

    public void clickTopDeals() {
        driver.findElement(topDeals).click();
    }

    public List<WebElement> grabProductName() {
        List<WebElement> pn = driver.findElements(productName);
        return pn;
    }



}
