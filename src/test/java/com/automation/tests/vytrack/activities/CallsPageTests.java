package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
    //go to Activities --> Calls
    //Verify that Log Call button is displayed
    private WebDriver driver;
    private Actions actions;

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//*[@class='title title-level-1' and contains(text(),'Activities')]");
private By logCallBtnBy = By.cssSelector("a[title='Log call']");
private By createCalendarEventBy = By.cssSelector(("a[title='Create Calendar event']"));

    private String storeManagerUsername = "storemanager85";
    private String storeManagerPassword = "UserUser123";


    @BeforeMethod
    public void setup(){
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
actions = new Actions(driver); //without creating a driver object we can't use Actions class
driver.manage().window().maximize();
driver.get("https://qa2.vytrack.com/user/login");


        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUsername);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(3);
   actions.moveToElement(driver.findElement(activitiesBy)).perform();
   BrowserUtils.wait(5);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void verifyLogButton(){
        driver.findElement(By.xpath("//span[text()='Calls']")).click();
        BrowserUtils.wait(5);
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        String actual= logCallBtnElement.getText();
        String expected = "Log Call";
//or Assert.assertEquals(locCallBtnElement.isDisplayed();
        Assert.assertEquals(actual, expected, "Button mismatch");
    }

    //Login as store manager
    //go to Activities --> Calendar Events
    //Verify that Create Calendar Event Button is displayed
    @Test
    public void verifyCalendarEventsPageTests(){
        driver.findElement(By.xpath("//span[text()='Calendar Events']")).click();
        BrowserUtils.wait(5);
        WebElement createCalendarEventElement = driver.findElement(createCalendarEventBy);
        Assert.assertTrue(createCalendarEventElement.isDisplayed());

    }



}
