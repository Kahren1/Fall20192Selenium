package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath {
    static String usernameLocator="//label[text()='Username']/following-sibling::input";
    static String passwordLocator="//label[text()='Password']/following-sibling::input";
    static String loginBtnLocator="//button[contains(text(),'Lo')]";

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

       driver.findElement(By.xpath(usernameLocator)).sendKeys("tomsmith");
       driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
       driver.findElement(By.xpath(loginBtnLocator)).click();



        BrowserUtils.wait(3);
        driver.quit();
    }

}
