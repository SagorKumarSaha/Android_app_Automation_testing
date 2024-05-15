package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class Capability {
	
	public AndroidDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void Capabilities() throws MalformedURLException {
		
		DesiredCapabilities de = new DesiredCapabilities();
		
		de.setCapability("deviceName", "Android_emulator");
		de.setCapability("platformName", "Android");
		de.setCapability("automationName", "UiAutomator2");
		de.setCapability("platformVersion", "14");
		de.setCapability("appPackage", "bd.com.evaly.evalyshop");
		de.setCapability("appActivity", "bd.com.evaly.evalyshop.ui.main.MainActivity");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		driver = new AndroidDriver(url, de);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("Application Started");

	}
	
	//@AfterSuite
		/*public void close() {
			driver.close();
		}*/

}
