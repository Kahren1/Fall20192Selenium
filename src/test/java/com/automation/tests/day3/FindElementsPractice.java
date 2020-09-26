package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");


        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("john@gmail.com");

        WebElement signUp = driver.findElement(By.className("radius"));
        signUp.click();

        WebElement message = driver.findElement(By.tagName("h3"));

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = message.getText();//<h3>Text</h3>

        if(actual.equals(expected)){
            System.out.println("test passed!");
        }

        Thread.sleep(3000);

       driver.quit();

    }
}
