package com.appium.test;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class DragAndDrop extends base 
{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Tap/Click on Views
				TouchAction touch = new TouchAction(driver);
				driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
				
				driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
				
				WebElement drag = driver.findElementsByClassName("android.view.View").get(0);
				WebElement drop = driver.findElementsByClassName("android.view.View").get(1);
				touch.longPress(longPressOptions().withElement(element(drag))).moveTo(element(drop)).release().perform();
//				touch.longPress(element(drag)).moveTo(element(drop)).release().perform();
	}

}
