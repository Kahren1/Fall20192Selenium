package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        //two steps to interact with the dropdown
        //create a webElement object, pass webElement object into a Select constructor
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select (simpleDropdown);

        //select by VisibleText? index? value?
        //<option value="1">Option 1</option>
        //...selected by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");

        BrowserUtils.wait(3);
        driver.quit();
    }


}
