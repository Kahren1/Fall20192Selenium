package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class SelectByIndex {
    public static void main(String[] args) {
       WebDriver driver = DriverFactory.createDriver("chrome");
       driver.get("http://practice.cybertekschool.com/dropdown");
       driver.manage().window().maximize();
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(0);
        System.out.println(stateSelect.getFirstSelectedOption().getText());
        BrowserUtils.wait(3);

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);
        System.out.println("Is multiple?  "+stateSelect.isMultiple());
        System.out.println(stateSelect.getFirstSelectedOption().getText());



        BrowserUtils.wait(3);
        driver.quit();

    }
}
