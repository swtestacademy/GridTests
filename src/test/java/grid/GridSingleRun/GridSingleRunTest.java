package grid.GridSingleRun;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by onurb on 26-Nov-16.
 */
public class GridSingleRunTest {

    static WebDriver driver;

    //Setup Driver
    @BeforeClass
    public static void setupTest() throws MalformedURLException {
        //FIREFOX
        //String geckoDriverLocation = System.getProperty("user.dir") + "\\tools\\drivers\\firefox\\
 /*       String geckoDriverLocation = "C:\\Selenium\\drivers\\firefox\\geckodriver.exe";
        System.out.println("Gecko Driver: " + geckoDriverLocation );
        System.setProperty("webdriver.gecko.driver", geckoDriverLocation);*/
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);



        //CHROME
        /*String chromeDriverLocation = System.getProperty("user.dir") + "\\tools\\drivers\\chrome\\chromedriver.exe";
        System.out.println("Chrome Driver: " + chromeDriverLocation );
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();*/
    }

    @org.junit.Test
    public void singleGridRunTest() {
        //Navigate to facebook.com
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();

        //Find Login Button
        WebElement loginButton = driver.findElement(By.id("loginbutton"));

        loginButton.click();

    }

    //Close Driver
    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}
