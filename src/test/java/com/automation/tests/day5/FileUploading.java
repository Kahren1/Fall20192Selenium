package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
     WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

        WebElement upload = driver.findElement(By.id("file-upload"));
        System.out.println(System.getProperty("user.dir")+"/pom.xml");
        //cloud doesn't work, should be on my computer
        String filePath=System.getProperty("user.dir")+"/pom.xml";
        String filePath2 = "C:/Users/Kahren/Desktop/HHS Child Supp Ltr.docx";
       upload.sendKeys(filePath2);

       WebElement submitButton=driver.findElement(By.id("file-submit"));
       submitButton.click();


        BrowserUtils.wait(4);
        driver.quit();
    }
}
