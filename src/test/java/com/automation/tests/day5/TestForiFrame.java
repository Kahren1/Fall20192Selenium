package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);

        //Before looking for an element with the frame, switch to that iFrame!
        driver.switchTo().frame("mce_0_ifr");
//now, the iFrame content becomes visible
        WebElement textInputInsideFrame = driver.findElement(By.id("tinymce"));
        System.out.println(textInputInsideFrame.getText());
        BrowserUtils.wait(4);

        textInputInsideFrame.clear();
        textInputInsideFrame.sendKeys("Hello world!");
        BrowserUtils.wait(4);

        //exit from the frame
        driver.switchTo().defaultContent();
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());


        driver.quit();
    }
}
