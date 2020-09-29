package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyThatElementisGone {
    /**
     * How to verify that element does not exist anymore
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement disappearingButton = driver.findElement(By.id("disappearing_button"));
        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.id("disappearing_button"));
        if (list.size() != 0) {
            System.out.println("element is there");
        }
        disappearingButton.click();
        list = driver.findElements(By.id("disappearing_button"));
        if (list.isEmpty()) {
            System.out.println("element disappeared");
        }
        Thread.sleep(2000);
//to find all buttons

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(2000);
//actually, no need to refresh the collection, because page never refreshes here
            //we don't do any navigagion, page does not refresh by itself
          //  buttons = driver.findElements(By.tagName("button"));

        }


        driver.quit();


    }

}
