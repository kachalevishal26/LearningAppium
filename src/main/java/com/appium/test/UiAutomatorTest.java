package com.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiAutomatorTest extends base 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.findElementByAndroidUIAutomator("attribute(\"value\")");
		//We cannot use "" inside "" so we use \ for using "" inside "" 
		//findElementByAndroidUIAutomator will get us multiple results.
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		    
		//Validate clickable feature for all options
		//driver.findElementByAndroidUIAutomator("new UiSelector().property(value)");
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize());
		
	}
}
