package com.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//For finding elements these are feasible: xpath, id, classname & androidUiAutomator
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		//When there are multiple elements with same tag name then we can use below method
		//enclosing the tag name with () after that put the tag name index in square brackets. []
		// ---            (//android.widget.RelativeLayout)[2]
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		driver.findElementByClassName("android.widget.EditText").sendKeys("Test Passed");
		driver.findElementByXPath("//android.widget.Button").click();

	}

}
