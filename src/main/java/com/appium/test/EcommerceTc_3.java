package com.appium.test;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceTc_3 extends EcommerceBase
{

	public static void main(String[] args) throws MalformedURLException 
	{
		//Selecting product and perform Add to Cart
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
		
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));");
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))."
	     		+ "scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
	     
	    int count = driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList")).size();
	    
	    for (int i = 0; i < count; i++) 
	    {
	    	String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
	    	if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
	    
	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    String lastPageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
	    assertEquals(lastPageText, "Jordan 6 Rings","Mismatched Product");
		
	}

}
