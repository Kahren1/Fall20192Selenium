package com.automation.tests.day8;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    //
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST, confusingly, runs before everything");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST is the very last one to run");
    }

    //runs only once regardless of number of tests
    //before @beforemethod and before any test, but after @beforeTest
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    //done once in a class after all tests
    @AfterClass
    public void afterClass(){
            System.out.println("AFTER CLASS");}

    //runs before every test automatically
    //works as a set=up for every test
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }
    //runs automatically aver every test
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }

    @Test(description="basic test")
public void test1(){
        System.out.println("TEST 1");
    String expected ="apple";
    String actual = "apple";
    Assert.assertEquals(actual, expected);
}
@Test
public void test2(){
    System.out.println("TEST 2");
        int num1=5;
        int num2=10;
        //it is called had assertion
    //if assertion fails it stops the execution(due to exception)
        Assert.assertTrue(num1>num2);
}

}
