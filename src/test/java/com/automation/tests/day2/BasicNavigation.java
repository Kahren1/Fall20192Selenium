package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //to start Selenium scrip we need:
        //set up webdriver (browser driver)
        WebDriverManager.chromedriver().setup();
        //creat webdriver object
        WebDriver driver = new ChromeDriver();
        //in selenium, everything start from WebDriver interface
        driver.get("http://google.com"); //to open a website
        Thread.sleep(3000);//wait for demo purposes

        String title = driver.getTitle();//returns page title
        String expectedTitle="Google";
        System.out.println("Page title is "+title);
        if (expectedTitle.equals(title)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        //browser can't close itself
        driver.close();


    }
}
