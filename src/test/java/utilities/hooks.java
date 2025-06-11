package utilities;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class hooks {

    public TestContextSetup testContextSetup;
    public hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
    @After
    public void teardown() throws IOException {
        // Code to close the browser or clean up resources
        testContextSetup.baseClass.globalDriver().quit();
        System.out.println("Teardown: Closing the browser and cleaning up resources.");
    }


    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        // Code to take a screenshot or perform any action after each step
        System.out.println("After Step: Taking a screenshot or performing an action.");
        // You can implement screenshot logic here if needed
        if(scenario.isFailed()){
            WebDriver driver = testContextSetup.baseClass.globalDriver();
            File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] filecontent = FileUtils.readFileToByteArray(sourcepath);
            scenario.attach(filecontent, "image/png", "screenshot");
        }
    }
}
