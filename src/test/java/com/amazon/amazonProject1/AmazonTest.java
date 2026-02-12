package com.amazon.amazonProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.net.URL;

public class AmazonTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws Exception {
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
            
        } else if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        } else if(browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        } else {
            throw new Exception("Browser not supported");
        }
    }

    @Test
    public void amazonSearch() {
        driver.get("https://www.amazon.in/");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
