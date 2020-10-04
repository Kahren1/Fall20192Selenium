package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //get all two checkboxes, click on them one-by-one
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        //iterate over the collection of checkboxes
        for (int i=0; i<checkBoxes.size();i++) {
            //if checkbox is not clicked, then click
            if (checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled()
                    && (!checkBoxes.get(i).isSelected())) {
                checkBoxes.get(i).click();
                System.out.println("checkbox "+ (i+1) +" is clicked!");
            }else{
                System.out.println("checkbox "+(1+i) + " is not clicked!");
            }
            BrowserUtils.wait(2);
        }


        driver.quit();

    }

}
