package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        //#TASK
        //verify that the 1st checkbox is NOT selected, the 2nd IS selected
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if (!checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected()) {
            System.out.println("test passed, checkbox 1 is NOT selected, 2 IS ");
        } else {
            System.out.println("test failed");
        }

        checkBoxes.get(0).click();
        BrowserUtils.wait(2);

        if (checkBoxes.get(0).isSelected()) {
            System.out.println("Test passed, Checkbox 1 is selected after being clicked on");
        } else {
            System.out.println("Test failed, Checkbox 1 is NOT selected after being clicked on");
        }

        if (checkBoxes.get(1).isSelected()) {
            System.out.println("test passed, checkbox 2 IS selected");
        } else {
            System.out.println("test failed, checkbox 2 IS NOT selected");
        }
        BrowserUtils.wait(2);
        driver.quit();

    }
}
