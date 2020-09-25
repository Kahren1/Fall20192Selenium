package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
//closes just one window
       driver.close();

       Thread.sleep(2000);
        //kills the browser opened by the browser driver
        driver.quit();


    }
}
