package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        //to start Selenium scrip we need:
        //set up webdriver (browser driver)
        WebDriverManager.chromedriver().setup();
        //creat webdriver object
        WebDriver driver = new ChromeDriver();
        //in selenium, everything start from WebDriver interface
        driver.get("http://google.com"); //to open a website


    }
}
