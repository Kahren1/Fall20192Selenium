package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        //you need to cast if the reference type is a WebDriver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.wait(3);
        for(int i=0;i<10;i++) {
            js.executeScript("window.scrollBy(0, 250)"); //scroll down by 250 pixels - coordinates x,y - where to?
            BrowserUtils.wait(2);
        }
    }
    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        WebElement linkElement = driver.findElement(By.linkText("Cybertek School"));
        //0 index means first webelement after the comma
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", linkElement);
    }
}
