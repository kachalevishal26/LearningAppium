package com.appium.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceTc_4 extends EcommerceBase
{

	public static void main(String[] args) throws MalformedURLException, Exception 
	{
		//Adding two different products into cart
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

		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(4000);
		//Instead of writing these codes again we can create function for recurring objects.
		//	    String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		//	    amount1 = amount1.substring(1);
		//	    double amount1value = Double.parseDouble(amount1);

		//Verification
		//Value11 - $160.97
		//	    String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		//	    //remove dollar from amount
		//	    double amount1value = getAmount(amount1); 
		//	    
		//	    String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		//	    double amount2value = getAmount(amount2);
		//	    
		//	    double sumOfProducts = amount1value + amount2value;
		//	    System.out.println("Sum: "+sumOfProducts);

		int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum = 0;
		for (int i = 0; i < count; i++) 
		{
			String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amountValue = getAmount(amount);
			sum = sum + amountValue;
		}
		System.out.println("Sum: "+sum);
		
		String total = driver.findElementsById("com.androidsample.generalstore:id/totalAmountLbl").get(0).getText();
		double totalValue = getAmount(total);
		System.out.println("Total :"+totalValue);
		assertEquals(sum, totalValue);
	}

	public static double getAmount(String value)
	{
		value = value.substring(1);
		double amount2Val = Double.parseDouble(value);
		return amount2Val;
	}

}
