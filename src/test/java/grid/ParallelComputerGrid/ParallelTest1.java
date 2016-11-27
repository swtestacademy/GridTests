package grid.ParallelComputerGrid;

import org.junit.After;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by ONUR on 24.11.2016.
 */
public  class ParallelTest1 extends DriverManager {

        //Chrome Test
        @Test
        public void testChrome1() throws MalformedURLException {
            driver = new DriverManager().getDriver("chrome");
            driver.navigate().to("http://www.facebook.com/");
            driver.manage().window().maximize();
        }

        //Firefox Test
        @Test
        public void testFirefox1() throws MalformedURLException {
            driver = new DriverManager().getDriver("firefox");
            driver.navigate().to("http://www.amazon.com/");
            driver.manage().window().maximize();
        }

        @After
        public void quitDriver() {
            driver.quit();
        }
}

