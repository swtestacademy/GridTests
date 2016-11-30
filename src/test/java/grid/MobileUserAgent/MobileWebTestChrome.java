package grid.MobileUserAgent;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by onurb on 29-Nov-16.
 */
public class MobileWebTestChrome {

    private static WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver,10);

    @BeforeClass
    public static void setup () {
        //Chrome Driver Decleration
        String chromeDriverLocation = "C:\\Selenium\\drivers\\chrome\\chromedriver.exe";
        System.out.println("Chrome Driver: " + chromeDriverLocation );
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        //Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void mobileWebTestChrome () throws InterruptedException {
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
