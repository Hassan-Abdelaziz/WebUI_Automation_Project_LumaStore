package com.softwaretestingboard.magento.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        //  Add ad block extension
        EdgeOptions options = new EdgeOptions();
        options.addExtensions (new File("src/test/resources/Plus Ad Blocker - Chrome Web Store 0.0.1.0.crx"));

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



//    JavascriptExecutor js;
//if (driver instanceof JavascriptExecutor) {
//        js = (JavascriptExecutor) driver;
//    }
//js.executeScript("return document.getElementsByClassName('review-info-star')[0].remove();");

}
