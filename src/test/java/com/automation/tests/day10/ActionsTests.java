package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
                driver.manage().window().maximize();
                actions = new Actions(driver);

    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();

    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 =driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        //always finish actions with perform()
        // actions.moveToElement(img1).pause(1000).build().perform() - build is needed when actions are combined
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                //build these actions and perform them
                build().perform();

        //hover on the first image (don't forget perform()!!!)
        //verify that "name: user1 is displayed

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("(//h5)[1]"));

        //checking if the block of code becomes visible
        Assert.assertTrue(imgText1.isDisplayed());
        BrowserUtils.wait(2);
        //move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        //hover on "enabled"
        //hover on "downloads"
        //click on PDF
        WebElement enabledElement = driver.findElement(By.id("ui-id-3"));
        WebElement downloadElement = driver.findElement(By.id("ui-id-4"));
        WebElement pdfElement = driver.findElement(By.id("ui-id-5"));
        actions.moveToElement(enabledElement).
                pause(1000).
        moveToElement(downloadElement).
                pause(1000).
                click(pdfElement).
                build().perform();
    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[text()='Accept Cookies']")).click();
        BrowserUtils.wait(3);

        WebElement earthElement = driver.findElement(By.id("droptarget"));
        WebElement moonElement = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moonElement,earthElement).perform();

        String expected = "You did great!";
                String actual= earthElement.getText();
                Assert.assertEquals(actual, expected, "Message mismatch!");
    }


}
