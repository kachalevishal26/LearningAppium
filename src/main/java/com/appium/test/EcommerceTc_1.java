package com.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceTc_1 extends EcommerceBase
{
	//Filling user details & click on button
	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Dropdown
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
		driver.findElementByXPath("//*[@text='Brazil']").click();
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aditi Varale");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
	}

}
