
package com.amazon.amazonProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;


public class AmazonTest {

    WebDriver driver;
    @Parameters("browser")
    @BeforeTest
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
  

        DesiredCapabilities cap = new DesiredCapabilities();

        if(browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        }
        else if(browser.equalsIgnoreCase("edge")) {
            cap.setBrowserName("edge");   
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
    }

    @Test
    public void amazonSearch() throws InterruptedException {

        driver.get("https://www.amazon.in");
        Thread.sleep(5000);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        System.out.println("Amazon Test Executed");
    }
}
