package pageObjects;

import org.openqa.selenium.WebDriver;


public class pageObjectManager {

    public WebDriver driver;
    public landingPageObjects landingPageObjects;
    public OfferPageObjects offerPageObjects;



    public pageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public landingPageObjects LandingPage(){
        landingPageObjects = new landingPageObjects(driver);
        return landingPageObjects;
    }

    public OfferPageObjects offerPage(){
        offerPageObjects = new OfferPageObjects(driver);
        return offerPageObjects;
    }
}