package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //ebayTest();
        //amazonTest();
        wikiTest();
    }

    public static void ebayTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        //go to ebay
        driver.get("https://www.ebay.com/");

        //enter search item
        WebElement searchBox = driver.findElement(By.name("_nkw"));
        searchBox.sendKeys("java book"); //could have added Keys.ENTER
        Thread.sleep(3000);

        //click on search button
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();
        //print number of results

//in HTML, tags are always purple in color
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        String searchResultsChunk = searchResults.getText().split(" ")[0];
        System.out.println(searchResultsChunk);
        Thread.sleep(3000);

        driver.quit();
    }

    /*
    go to amazon
    enter search item
    click on search button
    verify title contains search item
     */
    public static void amazonTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        //go to amazon
        driver.get("https://www.amazon.com/");


        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java book", Keys.ENTER);

        // WebElement searchButton = driver.findElement(By.id("nav-search-submit-text"));
        //searchButton.click();

        //verify that title contains search term
        String expectedTitle = "java book";
        String title = driver.getTitle();
        if (title.contains(expectedTitle)) {
            System.out.println("Verified - title contains search item");
        } else {
            System.out.println("Test failed");
        }
        Thread.sleep(2000);
        driver.quit();
    }

    /*
    got to wikipedia.org
    enter search item 'selenium webdriver'
    click on search button
    click on search result 'Selenium (software)'
    verify url ends with'Selenium_(software)'
     */
    public static void wikiTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        //enter search item 'selenium webdriver'
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");
//        WebElement searchButton = driver.findElement(By.className("pure-button pure-button-primary-progressive"));

        //click on search button
        WebElement searchButton = driver.findElement(By.name("go"));
        searchButton.click();
//click on search result 'Selenium (software)'
        WebElement searchResult = driver.findElement(By.partialLinkText("Selenium (software)"));
        searchResult.click();

        //verify url ends with'Selenium_(software)'
        String expectedURL = "Selenium_(software)";
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        if (actualURL.endsWith(expectedURL)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
        Thread.sleep(2000);
        driver.quit();

    }

}
