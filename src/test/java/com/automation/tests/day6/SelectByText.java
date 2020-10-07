package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        //two steps to interact with the dropdown
        //create a webElement object, pass webElement object into a Select constructor
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);

        //select by VisibleText? index? value?
        //<option value="1">Option 1</option>
        //...selected by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        //directly, without creating Webelement reference, just an object
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByValue("1970");
        selectMonth.selectByValue("10");
        selectDay.selectByValue("5");

        //select all months
        for (int i = 0; i < 12; i++) {
            //selecting each month
            selectMonth.selectByValue("" + i);
            BrowserUtils.wait(1);
        }

        List<WebElement> days = selectDay.getOptions();

        for (WebElement day : days) {
            String dayName = day.getText();
            //selecting a DAY by visibleText
            selectDay.selectByVisibleText(dayName);
            //BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
        Select selectState = new Select(driver.findElement(By.id("state")));

        //select an option by value
        // selectState.selectByValue("MD");
        selectState.selectByVisibleText("Maryland");

        //verification
        //currently selected option
        //option is a webelement
        String selected = selectState.getFirstSelectedOption().getText();
        if (selected.equals("Maryland")) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
//getting all the states from the dropdown
        List<WebElement> stateOptionList = selectState.getOptions();
        for (WebElement stateOption : stateOptionList) {
            System.out.print(stateOption.getText() + "   ");
            System.out.println(stateOption.getAttribute("value"));
        }


        BrowserUtils.wait(5);
        driver.quit();
    }


}
