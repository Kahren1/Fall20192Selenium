package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        //we get the driver object from @beforemethod
        driver.get("http://google.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("Java", Keys.ENTER);


        BrowserUtils.wait(3);
        List <WebElement> searchResults = driver.findElements(By.tagName("h3"));
        for(int i=0; i<searchResults.size();i++){
            String var = searchResults.get(i).getText();
            if(var.length()>0) {
                System.out.println(searchResults.get(i).getText());
                if(!var.toLowerCase().contains("java")){
                    System.out.println(var);
                }
                //test without assertion is a useless test
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        //close the driver, destroy webdriver object
       driver.quit();
    }
}
