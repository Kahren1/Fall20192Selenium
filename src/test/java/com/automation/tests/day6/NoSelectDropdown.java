package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropdown {
//some dropdowns are not based on select, but are a collection of links
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://practice.cybertekschool.com/dropdown");
    driver.manage().window().maximize();
    BrowserUtils.wait(3);


    WebElement dropdownMenuLink= driver.findElement(By.id("dropdownMenuLink"));
    dropdownMenuLink.click();
    BrowserUtils.wait(2);
    //it is not an option, it's a link! treat is like a link
    //it is a noselect dropdown
    WebElement amazon=driver.findElement(By.linkText("Amazon"));
    amazon.click();

    driver.navigate().back();

    dropdownMenuLink= driver.findElement(By.id("dropdownMenuLink"));
    dropdownMenuLink.click();

    WebElement etsy = driver.findElement(By.linkText("Etsy"));
    etsy.click();

    driver.navigate().back();

    //collect all links
    //need to reestablish connection to the page - element becomes stale
    dropdownMenuLink=driver.findElement(By.id("dropdownMenuLink"));
    dropdownMenuLink.click();

    List<WebElement> linksList = driver.findElements(By.className("dropdown-item"));
    for(WebElement link:linksList){
        System.out.println(link.getText() +"  "+ link.getAttribute("href"));

    }


    BrowserUtils.wait(3);
    driver.quit();
}
}
