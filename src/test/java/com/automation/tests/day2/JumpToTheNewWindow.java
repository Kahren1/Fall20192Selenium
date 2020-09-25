package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);

        //every tab (window) has some id, this id is called a window handle
        //we switch in between the windows using the window handle

        String windowHandle = driver.getWindowHandle();
        System.out.println("before switch: " + windowHandle);
        System.out.println("before switch: "+ driver.getCurrentUrl());
//getWindowHandles() returns a Set of id's of all currently opened windows
        //Set accepts unique values only
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        //since we have all windows
        //and we know id of the original window
        //we can say switch to something different (not equals to old window id

        for (String windowID: windowHandles){
            if(!windowID.equals(windowHandle)){
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("after switch: "+driver.getCurrentUrl());
        driver.close();
    }


    /**this method helps to switch between windows based on page title
     *
     * @param pageTitle
     * @param driver
     */

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window:windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }


}
