package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        WebElement subheader = driver.findElement(By.tagName("h4"));
        String actual = subheader.getText();
        if (expected.equals(actual)){
            System.out.println("test passed!");
        }else{
            System.out.println("test failed");
        }
        driver.quit();



    }
}
