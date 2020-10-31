package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/";

   private By userNameBy= By.id("prependedInput");
   private By passwordBy=By.id("prependedInput2");

   private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),\"Fleet\")]");
   private By vehiclesBy = By.linkText("Vehicles");
   private By subtitleBy = By.className("oro-subtitle");
   private By pageNumberBy=By.cssSelector("input[type='number']");

//setup
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        //login
        driver.findElement(userNameBy).sendKeys("storemanager85");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(5);

//navigation to Vehicles page
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(vehiclesBy).click();
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

    @Test (description = "verify that page subtitle is equal to All Cars")
    public void verifyPageSubTitle(){
        String expected="All Cars";
        //find subtitleElement
        WebElement subtitleElement = driver.findElement(subtitleBy);
        String actual= subtitleElement.getText();
        assertEquals(actual, expected, "Vehicles name did not match");
        BrowserUtils.wait(5);
    }
    //Given user is on the vytrack landing page
    //Then user logs on as a store manager
    //Then user navigates to Fleet-->Vehicles
    //And  user verifies that page number is equals to "1"

    @Test
    public void verifyPageNumber(){
        String expected ="1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");
        assertEquals(actual,expected, "Page number mismatch");

    }

}
