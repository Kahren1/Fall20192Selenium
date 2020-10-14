package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        //unit test
        //to ckeck if our method words properly
        //if assertion fails, it means our method doesn't work correctly
        String expected ="cba";
        String toReverse ="abc";
        String actual= reverseString(toReverse);
        System.out.println(verifyEquals(expected, actual));
    }
    //annotation
    @Test(description="Verify if a method can reverse a string")
public void test(){
        String expected = "lppa";
        String actual=reverseString("apple");
        //it comes from testng, junit also has this class
        //you can compare any data types
        //to verify is the expected result equals actual result
        Assert.assertEquals(actual, expected);
}
//public void method, no need to have it static
@Test(description="Verify if method can reverse a string")
public void test2(){
        String expected = "rac";
        String actual = reverseString ("car");
        Assert.assertEquals(actual, expected);

}


    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("test passed");
            return true;
        }else{
            System.out.println("test failed");
            System.out.println("expected "+expected);
            System.out.println("actual "+actual);
            return false;
        }
    }

    /**
     * This method reverses String
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str){
        String reversed="";
        for(int i=str.length()-1;i>=0;i--){
            reversed+=str.charAt(i);
        }
        return reversed;
    }
}
