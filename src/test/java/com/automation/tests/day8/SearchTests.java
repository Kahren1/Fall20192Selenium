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
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Java", Keys.ENTER);


        BrowserUtils.wait(3);
        List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
        for (int i = 0; i < searchResults.size(); i++) {
            String var = searchResults.get(i).getText();
            if (var.length() > 0) {
                System.out.println(searchResults.get(i).getText());
                if (!var.toLowerCase().contains("java")) {
                    System.out.println(var);
                }
                //test without assertion is a useless test
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    /**
     * Given user is on amazon.com page
     * When user enters "java" as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * And user verifies that title on the search item contains "Java"
     */
    @Test(description = "Search for Java book on amazon")
    public void amazonSearchTest() {
        driver.get("https://www.amazon.com/");
        //in case the item is not visible it helps to maximize window
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java");
        WebElement submitButton = driver.findElement(By.id("nav-search-submit-text"));
        submitButton.click();
        BrowserUtils.wait(5);
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
        //h2 elements are not clickable, even though they contain links
        //that's whay instead of collecting h2 elements
        //we collected all hyperlinks, all tag a
        //hyperlinks are always clickable
//        int i=0;
//        for(WebElement item:searchItems){
//            System.out.println(i+" "+item.getText());
//            i++;
//        }
        System.out.println("How many items found? " + searchItems.size());
        System.out.println(searchItems.get(1).getText());
        BrowserUtils.wait(5);
        searchItems.get(1).click();

        String productTitleName = driver.findElement(By.id("title")).getText();
        System.out.println(productTitleName);
        Assert.assertTrue(productTitleName.contains("Java"));
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        //close the driver, destroy webdriver object
        //driver.quit();
    }
}
