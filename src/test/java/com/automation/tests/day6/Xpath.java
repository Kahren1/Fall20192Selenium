package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
        //value can be inside ' ' or " "
        //if you don't know or want to skip the tagname, use *
        //here I used * instead of the button tagName
        WebElement btn2 = driver.findElement(By.xpath("//*[@name=\"button2\"]"));
        btn2.click();

        //verifying the result

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());






        BrowserUtils.wait(3);
        driver.quit();
    }
}
