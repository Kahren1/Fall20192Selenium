package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        WebElement subheader = driver.findElement(By.tagName("h4"));
        String actual = subheader.getText();
        if (expected.equals(actual)){
            System.out.println("test passed!");
        }else{
            System.out.println("test failed");
        }

        //click on Logout button
        //looks like a button, but it is not based on a <button tag - a link - a hyperlink - <a  tag
        //partialLinkText - contains()
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        System.out.println("logout:"+logout.getText());
//getAttribute() method returns any attribute value
        String href= logout.getAttribute("href");
        String className=logout.getAttribute("class");
        System.out.println("href: "+href);
        System.out.println("className: "+className);
        logout.click();
        Thread.sleep(3000);

        //let's enter invalid credentials

        driver.findElement(By.name("username")).sendKeys("user");
        driver.findElement(By.name("password")).sendKeys("user");
        Thread.sleep(2000);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        String expectedNegative = "Your username is invalid!";

       WebElement message2 = driver.findElement(By.id("flash"));
       String actualNegative = message2.getText();
        System.out.println(actualNegative);

       if(actualNegative.contains(expectedNegative)){
           System.out.println("Negative test passsed!");
       }




        driver.quit();
    }
}
