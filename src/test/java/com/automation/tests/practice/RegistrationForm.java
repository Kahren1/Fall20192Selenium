package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    //very happy path
    //enter first name, last name, userName, email, password, phone number, DOB, ... all fields
    //verify message: "You've successfully completed registration!
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy=By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneNumberBy = By.name("phone");
    private By maleButttonBy = By.cssSelector("input[value='male']");
    private By femaleButttonBy = By.cssSelector("input[value='female']");
    private By otherButttonBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    //Select dropdowns
    private By departmentBy = By.name("department");
    private By jobDropDownBy = By.name("job_title");

    //languages
    private By cPlusPlusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");


    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1() {
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(userNameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123456789");
        driver.findElement(phoneNumberBy).sendKeys("234-123-1231");
        driver.findElement(maleButttonBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/02/2003");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByValue("DA");
        Select jobTitleSelect = new Select(driver.findElement(jobDropDownBy));
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(javaBy).click();
       driver.findElement(signUpBy).click();
        BrowserUtils.wait(5);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You've successfully completed registration!", "Mismatch!");
    }

    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
       // String actual="first name must be more than 2 and less than 64 characters long";
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        boolean expected= warningMessage.isDisplayed();
        Assert.assertTrue(expected, "warning message not matching");
    }

    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningMessage= driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
