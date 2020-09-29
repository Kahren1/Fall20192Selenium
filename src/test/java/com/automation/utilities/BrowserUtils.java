package com.automation.utilities;

public class BrowserUtils {

    //methods that handle browser, manipulate browser
    //waits, clicks, switching between window frames

    public static void wait (int seconds){
        try{
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
