package utilities;

import org.openqa.selenium.WebDriver;
import pageObjects.pageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public pageObjectManager pom;
    public String prod;
    public baseClass baseClass;
    public resuable reusable;

    public TestContextSetup() throws IOException {

    baseClass = new baseClass();
 //   pom = new pageObjectManager(baseClass.globalDriver());
  // reusable = new resuable(baseClass.globalDriver());
    }

}
