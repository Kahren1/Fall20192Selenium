package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        //set up chromedriver class
        WebDriverManager.chromedriver().setup();
        //get chromeoptions object
        ChromeOptions chromeOptions=new ChromeOptions();
        //chromeOptions class used to customize browser for tests
        chromeOptions.setAcceptInsecureCerts(true); //to ignore lack of a secure certificate
        //while creating a driver, pass chromeOptions object
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void loginTest(){
        //go to Form Authentication Page
        //enter valid credentials tomsmith SuperSecretPassword
        //verify that the following subheader message "Welcome to secure area...." is displayed
        WebElement formAuthenticationLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthenticationLink.click();
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.sendKeys("tomsmith");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword");
        WebElement submitButton = driver.findElement(By.id("wooden_spoon"));
        BrowserUtils.wait(3);
        submitButton.click();
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        WebElement message= driver.findElement(By.tagName("h4"));
        String actual=message.getText();
        System.out.println(actual);
        //expected, actual, message in case of error
        Assert.assertEquals(expected, actual,"Subheader message doesn't match");
    }

    /**
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test (description = "forgot password message verification")
public void forgotPasswordTest(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("october16@gmail.com", Keys.ENTER);
        String expected="Your e-mail's been sent!";
        WebElement confirmationMessage = driver.findElement(By.tagName("h4"));
        String actual= confirmationMessage.getText();
        BrowserUtils.wait(3);
        Assert.assertEquals(expected,actual,"email sent confirmation message does not match!");
    }
    /**
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And user clicks on the first checkbox
     * Then user verifies that the checkbox #1 is selected
     */
    @Test (description = "checkbox selected verification")
    public void checkBoxSelectedTest(){

        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();

//        List<WebElement> checkboxesList = driver.findElements(By.tagName("input"));
//        WebElement checkbox1 = checkboxesList.get(0);
        //cssSelector: input:nth-of-type(1)
       WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
                checkbox1.click();
                Assert.assertTrue(checkbox1.isSelected(),"checkbox1 is not selected");



    }



}
