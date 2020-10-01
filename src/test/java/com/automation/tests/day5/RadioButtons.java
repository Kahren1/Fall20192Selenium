package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //let's find all radio buttons and click on them one-by-one
        List<WebElement> buttons = driver.findElements(By.tagName("input"));
        for(WebElement button:buttons){
            String idValue = button.getAttribute("id");
//.isSelected = if button has been clicked already
            boolean isSelected = button.isSelected();
            System.out.println(idValue + " is selected? " + isSelected);

            //if button is eligible to click
            //returns true if clickable
            if(button.isEnabled()) {

                BrowserUtils.wait(2);
                button.click();
                System.out.println("Clicked on: "+ idValue );
            }else{
                System.out.println("Button is disabled, not clicked: "+idValue);
            }
            System.out.println("");

        }

        driver.quit();
    }
}
