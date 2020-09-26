package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        //set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        //in Selenium, anything you want to find in a webpage
        //you need to wrap into a webelement object
        //By.name("q") --> name = "q"

        By halfBakedSearch = By.name("q");
        WebElement search = driver.findElement(halfBakedSearch);
        //once we found an element, enter text
        //WebDriver interacts with WebElements on the page
        //Keys.ENTER - to perform keyboard click
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);
        //<a> element is called link
        //visible text of this link can be used by selenium By.linkText(visibleText) to find it
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(3000);



        driver.quit();

    }
}
