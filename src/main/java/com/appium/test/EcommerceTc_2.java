package com.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static org.testng.Assert.*;
public class EcommerceTc_2 extends EcommerceBase
{

	public static void main(String[] args) throws MalformedURLException 
	{
		//Validation - Negative scenarios.
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Dropdown
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
		driver.findElementByXPath("//*[@text='Brazil']").click();
		
//		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aditi Varale");
//		driver.hideKeyboard();
//		driver.findElementByXPath("//*[@text='Female']").click();
		
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//Validation
		String toastMsg = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(toastMsg);
		assertEquals(toastMsg, "Please enter your name","Mismatch Validation!");
		
		
	}

}
