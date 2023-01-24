package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;

public class Ecommerce_Test extends Ecom_Base 
{
	public static void main(String[] args) throws Exception 
	{
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Fill User Details
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));");
		driver.findElementByXPath("//*[@text = 'Brazil']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aditi");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Select Product - Add to Cart
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")."scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))."
		     		+ "scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

//		Verify Cart
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		double sum = 0;
		for (int i = 0; i < count; i++) 
		{
			String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amountValue = getAmount(amount);
			sum = sum + amountValue;
		}
		System.out.println("Sum: "+sum);
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println("Total : "+totalValue);
		assertEquals(sum, totalValue);
		
//		Cart gestures
		TouchAction touch = new TouchAction(driver);
		
		//Terms - long press
		WebElement terms = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		touch.longPress(longPressOptions().withElement(element(terms)).withDuration(Duration.ofSeconds(2))).perform();
		driver.findElementById("android:id/button1").click();
		
		//Tap checkbox
		WebElement sendBox = driver.findElementByXPath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']");
		touch.tap(tapOptions().withElement(element(sendBox))).perform();
		
		//Web page
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		
	}
	public static double getAmount(String value)
	{
		value = value.substring(1);
		double amount2val = Double.parseDouble(value);
		
		return amount2val;
	}
}
