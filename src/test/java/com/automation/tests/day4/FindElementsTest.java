package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        //This is how to collect all links from the page?
        //---ever link has a tagName a
      List<WebElement> links = driver.findElements(By.tagName("a"));

      //to iterate over the collection and get the text from all hypertext elements:
        for(WebElement link:links){
            System.out.print(link.getText()+"   ");
            System.out.println(link.getAttribute("href"));
        }

        for(int i=1; i<links.size();i++){
            links.get(i).click();
            driver.navigate().back();
            Thread.sleep(1000);
           links= driver.findElements(By.tagName("a"));
        }


        driver.quit();
    }
}
