package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));

        //Is this select element supports selecting multiple options?
        //it is done by checking the value of the "multiple" attribute
        boolean isMultiple = languagesSelect.isMultiple();

        if (isMultiple) {
            languagesSelect.selectByVisibleText("Java");
            languagesSelect.selectByVisibleText("JavaScript");
            languagesSelect.selectByVisibleText("Python");
        }
//Let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();
        for(WebElement language:selectedLanguages){
            System.out.println(language.getText());
        }
        //unselected Java option among multiple selected options
languagesSelect.deselectByVisibleText("Java");
        languagesSelect.deselectAll();
        //is the list empty?
        System.out.println(languagesSelect.getAllSelectedOptions().size());

        BrowserUtils.wait(3);
        driver.quit();

    }


}
