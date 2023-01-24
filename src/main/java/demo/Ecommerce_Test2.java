package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;

public class Ecommerce_Test2 extends Ecom_Base 
{
	public static void main(String[] args) throws Exception 
	{
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Fill User Details
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		driver.findElementByXPath("//*[@text = 'Australia']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Aditi");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Select Product - Add to Cart
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")."scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))."
		     		+ "scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

		//Verify Cart
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		//Cart gestures
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
		Thread.sleep(8000);
		Set<String> context = driver.getContextHandles();
		for(String contextName : context)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("hello",Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}
