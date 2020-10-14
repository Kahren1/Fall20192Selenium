package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        System.out.println(heading.getText());
        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        System.out.println(home.getText());
        WebElement btn1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        btn1.click();
        WebElement btn2 = driver.findElement(By.cssSelector("[name='button2']"));
        btn2.click();
        WebElement btn3 = driver.findElement(By.cssSelector("[id^='button_']"));
        btn3.click();
        WebElement btn4 = driver.findElement(By.cssSelector("[onclick='button4()']"));
        btn4.click();
        BrowserUtils.wait(2);
        WebElement btn5 = driver.findElement(By.cssSelector("[onclick='button5()']"));
        btn4.click();
        WebElement btn6 = driver.findElement(By.cssSelector("#disappearing_button"));
        btn6.click();




        BrowserUtils.wait(3);
        driver.quit();
    }


}
