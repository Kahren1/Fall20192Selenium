package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("TEST 1");
        //to click on the first button
        buttons.get(0).click();
        BrowserUtils.wait(3);
//alert() is a method when you switch to an alert window
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

//clicking on the "Ok"
        driver.switchTo().alert().accept();

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();


        if (expected.equals(actual)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
            System.out.println("Actual: " + actual);
            System.out.println("Expected: " + expected);
        }

        System.out.println("TEST 2");
        //getting to the second alert and clicking on Cancel
        BrowserUtils.wait(3);
        buttons.get(1).click();//to click on the 2nd button
        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(3);

        String expected1 = "You clicked: Cancel";
        String actual1 = driver.findElement(By.id("result")).getText();

        if (expected1.equals(actual1)) {
            System.out.println("Cancel test passed");

        } else {
            System.out.println("test failed");
            System.out.println(actual1);
            System.out.println(expected1);
        }

        System.out.println("TEST 3");
        //Task: click on button #3
        //Enter text: Hello, World!
        //verify that result text ends with Hello, World!

       buttons.get(2).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!");

        alert.accept();

        BrowserUtils.wait(3);

        String expected2 = "Hello, World!";
        String actual2 = driver.findElement(By.id("result")).getText();
        System.out.println(actual2);
        if(actual2.endsWith(expected2)){
            System.out.println("test passed");
        }else{
        System.out.println("Test failed!");}


        BrowserUtils.wait(3);
        driver.quit();


    }
}
