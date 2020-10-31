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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {

    //go to Activities --> Create Calendar Event
    //Verify that Create Calendar Event button is displayed
    private WebDriver driver;
    private Actions actions;

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//*[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBy = By.cssSelector(("a[title='Create Calendar event']"));
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    //for some reason, end part of id is always different
    //that's why we use contains[*=] to partially match id.
    //We selected static part of id and provided into a locator

    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy= By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

    private String storeManagerUsername = "storemanager85";
    private String storeManagerPassword = "UserUser123";


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver); //without creating a driver object we can't use Actions class
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");


        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(storeManagerUsername);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(3);
        //hover over Activities, click on Calendar Events
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//span[text()='Calendar Events']")).click();
        BrowserUtils.wait(5);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


    @Test
    public void verifyCalendarEventsPageTests() {

        WebElement createCalendarEventElement = driver.findElement(createCalendarEventBy);
        Assert.assertTrue(createCalendarEventElement.isDisplayed());
    }

    /**
     * //in the BeforeMethod
     * Test case: Default Options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * <p>
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues() {
        driver.findElement(createCalendarEventBy).click();
        BrowserUtils.wait(5);
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        System.out.println(currentUserName);
        System.out.println(defaultOwnerName);
        Assert.assertEquals(currentUserName, defaultOwnerName);
        WebElement titleElement = driver.findElement(titleBy);
        //input elements don't contain text.Instead, text is inside attribute "value". Use getAttribute() method
        //to retrieve that value
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        //Default start date and time should be current date and time
        String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate,expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime=driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(actualTime, expectedTime);
    }
}
