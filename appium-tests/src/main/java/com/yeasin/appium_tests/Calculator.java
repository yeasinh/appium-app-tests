package com.yeasin.appium_tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Calculator {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		
		// Set the AppiumOptions for the Android emulator/device
		options.setCapability("platformName", "Android");
        options.setCapability("automationName", "UiAutomator2");
        
        options.setApp("E:\\SQA Projects\\apk-info.apk");
        
        // Set the app package and activity for the calculator
        options.setCapability("appPackage", "com.android.calculator2");
        options.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
        // Create the AndroidDriver instance
        URL url = new URL("http://192.168.0.110:4723");
	    AndroidDriver driver = new AndroidDriver(url, options);
	    
	    // Wait for the app to load
        Thread.sleep(5000);
	    
        // Perform addition
        performCalculation(driver, "2", "add", "3");

        // Perform subtraction
        performCalculation(driver, "5", "sub", "2");

        // Perform multiplication
        performCalculation(driver, "4", "mul", "3");

        // Perform division
        performCalculation(driver, "8", "div", "2");
        
        // Clear the result
        driver.findElement(By.id("clr")).click();

        // Close the app
        driver.quit();
	}
	
	private static void performCalculation(AndroidDriver driver, String operand1, String operator, String operand2) {
        // Tap on the first operand
        driver.findElement(By.id("digit_" + operand1)).click();

        // Tap on the operator
        driver.findElement(By.id("op_" + operator)).click();

        // Tap on the second operand
        driver.findElement(By.id("digit_" + operand2)).click();

        // Tap on the equals sign to get the result
        driver.findElement(By.id("eq")).click();

        // Print the result
        String result = driver.findElement(By.id("result")).getText();
        System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
    }
}
