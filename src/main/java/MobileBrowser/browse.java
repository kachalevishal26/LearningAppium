package MobileBrowser;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browse extends baseChrome 
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		AndroidDriver<AndroidElement>driver = capabilities();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElementByCssSelector("navbar-toggler-icon").click();
		driver.findElementByCssSelector("a[href*='products']").click();
		
		

	}

}
