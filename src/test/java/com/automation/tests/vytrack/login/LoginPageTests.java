package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Static import of all assertions
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    //credentials for store manager
    private String username="storemanager85";
    private String password= "UserUser123";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By submitBy = By.id("_submit");
    //in css selector > means the same as / in xpath
    private By warningMessageBy = By.cssSelector("[class='alert alert-error']>div");


    @Test(description = "Verify that warning message displays when user enters invalid user name")
    public void invalidUserName() {
        driver.findElement(userNameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123");
        BrowserUtils.wait(5);
        driver.findElement(submitBy).click();
        BrowserUtils.wait(5);
        WebElement warningElement = driver.findElement(warningMessageBy);
        String actual= warningElement.getText();
        String expected = "Invalid user name or password.";
//assertTrue(warningElement.isDisplayed(),"Warning message not displayed");
         assertEquals(actual, expected, "no match");
    }

    @Test(description="Verify that when user logs in as a store manager, title equals to Dashboard")
    //we can check the page title
    public void loginAsStoreManager(){
        BrowserUtils.wait(3);
        driver.findElement(userNameBy).sendKeys("storemanager83");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        String actual = driver.getTitle();
        String expected = "Dashboard";
        assertEquals(actual, expected, "test failed - title mismatch");
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {

        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object
            driver = null;
        }
    }

}
