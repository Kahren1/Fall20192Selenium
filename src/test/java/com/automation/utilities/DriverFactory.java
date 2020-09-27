package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    /**
     * this method returns webdriver object based on browser type
     * if you want to use chrome browser, provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */
    public static WebDriver createDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            //Vasya used WebDriverManager.chromedriver().version("79.0").setup() to fix timed out message
            WebDriverManager.chromedriver().setup();
          return new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

    }
}
