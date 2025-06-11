package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class baseClass {

    public WebDriver driver;

    public WebDriver globalDriver() throws IOException {
        FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        Properties prop = new Properties();
        prop.load(fi);
        String url = prop.getProperty("URL");
        String browser_prop = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven!=null ? browser_maven : browser_prop;

        if(url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL is not specified in the properties file.");
        }

        if(driver == null) {


        switch (browser.toLowerCase()) {
        case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

        case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

        case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Browser not supported: " + browser);

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        }
        driver.get(url);
        return driver;
    }
}
