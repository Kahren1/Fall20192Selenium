package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class JSExecutor2 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");

    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void verifyTitle() {
        String expected = "Practice";
        //we create javascriptexecutor object by casting a webdriver object
        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return doument.title = javascript code
        //document - represents HTML page
        String actual = ((JavascriptExecutor) driver).executeScript("return document.title").toString();
        Assert.assertEquals(actual, expected, "title mismatch!");
    }

    @Test
    public void clickTest() {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        //link.click();
        //after "" you can list webelements which will be used as a part of my javascript code
        //it's vargargs, so you can list 0+
        //arguments - listed after
        //use index to get specific element
        //like picking from an array
        //perform an action with a javascriptexecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        BrowserUtils.wait(3);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void testInputText() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("wooden_spoon"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to get text from input box - read attribute "value"
        //to enter text - set attribute "value"
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginBtn);
        BrowserUtils.wait(3);

        String actualSubheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        Assert.assertEquals(actualSubheader, expected, "Mismatch!");
    }

    @Test
    public void scrollToElement() {
        BrowserUtils.wait(5);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        Assert.assertTrue(link.isDisplayed());
    }

    @Test
    public void scrollTest() {
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0, 100)");
            BrowserUtils.wait(1);
        }
    }


}
