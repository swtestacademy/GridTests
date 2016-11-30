package grid.MobileUserAgent;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;

/**
 * Created by onurb on 29-Nov-16.
 */
public class MobileWebTestFirefox {

    private static WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver,10);

    @BeforeClass
    public static void setup () throws MalformedURLException {
        //Declare Firefox Driver Location
        String geckoDriverLocation = "C:\\Selenium\\drivers\\firefox\\geckodriver.exe";
        System.out.println("Gecko Driver: " + geckoDriverLocation );
        System.setProperty("webdriver.gecko.driver", geckoDriverLocation);

        //Firefox Profile Settings
        FirefoxProfile profile = new FirefoxProfile();
        //******************************************************
        // This is Optional For My Work Laptop Security Settings
        //******************************************************
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //******************************************************
        //******************************************************

        //Change User Agent to HTC ONE M9
        profile.setPreference("general.useragent.override", "Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");  // here, the user-agent is HTC ONE M9

        //Set Profile to Firefox Driver
        driver = new FirefoxDriver(profile);
    }

    @Test
    public void mobileWebTestFirefox () throws InterruptedException {
        //Go To Amazon.com
        driver.navigate().to("http://www.amazon.com/");

        //Get search bar and search button
        WebElement searchBar = driver.findElement(By.id("nav-search-keywords"));
        WebElement searchButton = driver.findElement(By.xpath("./*//*[@id='nav-search-form']/div[1]/div/input"));

        //Write Sony Headphones to the search bar and click search button
        searchBar.sendKeys("Sony Headphones");
        searchButton.click();

        //Wait until first element image is visible
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='resultItems']/li[1]/a/div/div[1]/div/img")));

        //Get first element's text and write it to the console
        String firstSearchElementText = driver.findElement(By.xpath(".//*[@id='resultItems']/li[1]/a/div/div[2]/h5")).getText();
        System.out.println("First Search Element Name: " + firstSearchElementText);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
