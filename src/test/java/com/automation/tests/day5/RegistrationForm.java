package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        BrowserUtils.wait(5);
        //enter first name

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Vasiliy");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Shevchenko");

        WebElement userName = driver.findElement((By.name("username")));
        userName.sendKeys("Vasya");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("vasya@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        email.sendKeys("superSecretPassword");

        WebElement phoneNumber = driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("301-675-2979");

        List<WebElement> genderButtons = driver.findElements(By.name("gender"));
        //select gender
        genderButtons.get(1).click(); //select female

        WebElement birthDay = driver.findElement(By.name("birthday"));
        birthDay.sendKeys("01/01/2005");

        WebElement javaCheckbox = driver.findElement(By.id("inlineCheckbox2"));
        javaCheckbox.click();

        BrowserUtils.wait(3);

        WebElement signupButton = driver.findElement(By.id("wooden_spoon"));
        signupButton.click();

        BrowserUtils.wait(5);

        driver.quit();


    }


}
