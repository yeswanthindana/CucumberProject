package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class resuable {

    public WebDriver driver;

    public resuable(WebDriver driver){
        this.driver = driver;
    }

    public void switchToOffersPage() {
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        for (String handle : handles){
            driver.switchTo().window(handle);
             System.out.println(driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains("Offers"))
            {
                System.out.println("Switched to Offers page");
                break;
            }

        }
    }
}
