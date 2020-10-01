package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
      WebDriver driver = DriverFactory.createDriver("chrome");
      driver.get("http://practice.cybertekschool.com/radio_buttons");
      driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));

        //if visible    and       clickable, both methods apply for any webElement
        if(blackButton.isDisplayed()&&blackButton.isEnabled()) {
            System.out.println("Black button clicked");
            blackButton.click();
            BrowserUtils.wait(2);
        }else{
            System.out.println("Failed to click");
        }
        //how to verify that button is clicked
        if(blackButton.isSelected()){
            System.out.println("Test passed, black button is selected");
        }else{
            System.out.println("Test failed");
        }
//element must be present .findElements().size()==0 visible .isDisplayed clickable isEnabled
BrowserUtils.wait(2);
driver.quit();
    }
}
