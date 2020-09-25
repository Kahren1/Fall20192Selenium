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

        //the althernative way first parameter: Webdriver type, second: path to the wedriver
        //System.setProperty("webdriver.chrome.driver", "chromedriver");


        WebDriver driver = new ChromeDriver();
        //in selenium, everything start from WebDriver interface
        driver.get("http://google.com"); //to open a website
        driver.manage().window().maximize();//to maximize a browser
        //driver.manage().window().fullscreen();
        Thread.sleep(3000);//wait for demo purposes

        String title = driver.getTitle();//returns page title
        String expectedTitle="Google";
        System.out.println("Page title is "+title);
        if (expectedTitle.equals(title)){
            System.out.println("test passed, contains Google");
        }else{
            System.out.println("test failed");
        }
//go to another website within the same window
        driver.navigate().to("http://amazon.com");
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("test passed, contains amazon");
    }else{
        System.out.println("test failed");
    }
        //come back to google
        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");
//again, going to amazon
        driver.navigate().forward();
        System.out.println("Title: "+driver.getTitle());
        //reload
        driver.navigate().refresh();

        //playing
        System.out.println("URL: "+driver.getCurrentUrl());

//driver.navigate().to() is the same as driver.get()

        //browser can't close itself
        driver.close();
    }

    /**
     * Check if two strings are the same. if yes, print Test passed! message
     * if not, pring Test failed! message
     * @param arg1
     * @param arg2
     */
    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("verifyEquals: Test passed!");
        }else{
            System.out.println("verifyEquals: Test failed!");
        }
    }
}
