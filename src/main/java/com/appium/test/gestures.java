package com.appium.test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

//We need to import below three packages manually as it's not imported automatically
import static  io.appium.java_client.touch.TapOptions.tapOptions;
import static  io.appium.java_client.touch.offset.ElementOption.element;
import static  io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class gestures extends base {

	public static void main(String[] args) throws MalformedURLException 
	{
		
		AndroidDriver<AndroidElement> driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//Tap
		//tap, press & release, scroll, swipe, drag & drop: All done with TouchAction class
		TouchAction touch = new TouchAction(driver);
		WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		touch.tap(tapOptions().withElement(element(expandList))).perform();
		
		WebElement customAdapt = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
		touch.tap(tapOptions().withElement(element(customAdapt))).perform();
		
		WebElement peopleName = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		
		touch.longPress(longPressOptions().withElement(element(peopleName)).withDuration(Duration.ofSeconds(5))).release().perform();
		touch.perform();
		System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
		
		System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Sample action']").getText());
		
	}
}
