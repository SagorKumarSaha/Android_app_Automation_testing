package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Search_and_addToCart extends Capability {
	
	@Test(priority=1)
	public void search_product() throws InterruptedException {
		
		Thread.sleep(1000);
		//permission allow button
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(1000);
		
		//search bar click
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"What would you like to buy?\"]")).click();
		Thread.sleep(1000);
		
		//2nd page search bar
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/search")).click();
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/search")).sendKeys("samsung ac");
		Thread.sleep(1000);
		driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","done"));
		Thread.sleep(2000);
		
		//click on the desired product after search
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"bd.com.evaly.evalyshop:id/"
				+ "title\" and @text=\"Samsung AR18CVFYAWK1FE Inverter Step-Up AC with Digital Inverter - 1.5 Ton - White\"]")).click();
		Thread.sleep(3000);
		
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Specifications\"));"));
		Thread.sleep(3000);
		
		//add to cart option click
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/add_cart")).click();
		Thread.sleep(2000);
		
		//click on the cart option after adding the item in the cart
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"bd.com.evaly.evalyshop:id"
				+ "/navigation_bar_item_icon_view\"])[3]")).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void checkout() throws InterruptedException {
		
		//cart item is selected or not for check out
		WebElement e = driver.findElement(By.xpath("(//android.view.View[@resource-id=\"bd.com.evaly.evalyshop:id/checkBox\"])[2]"));
		String s = e.getAttribute("checked");
		//System.out.println(s);
		
		if(s.equalsIgnoreCase("false")==true) {
			System.out.println("All selected...");
			Thread.sleep(1000);
			//click the checkout option
			driver.findElement(By.id("bd.com.evaly.evalyshop:id/checkoutBtn")).click();
			Thread.sleep(2000);
		}else {
			System.out.println("Not selected... Selecting all option...");
			driver.findElement(By.xpath("(//android.view.View[@resource-id=\"bd.com.evaly.evalyshop:id/checkBox\"])[2]")).click();
			Thread.sleep(1000);
			//click the checkout option
			driver.findElement(By.id("bd.com.evaly.evalyshop:id/checkoutBtn")).click();
			Thread.sleep(2000);
		}
	}
	
	@Test(priority=3)
	public void signin() throws InterruptedException {
		
		//email field
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/emailAddress")).click();
		Thread.sleep(500);
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/emailAddress")).sendKeys("........"); //provide your email
		Thread.sleep(500);
		
		//password field
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/password")).click();
		Thread.sleep(500);
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/password")).sendKeys("12345678");
		Thread.sleep(1000);
		
		//click on the logo to hide the keyboard
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/logo")).click();
		Thread.sleep(1000);
		
		//click on the sign in button
		driver.findElement(By.id("bd.com.evaly.evalyshop:id/sign_in")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void placeOrder() throws InterruptedException{
		
		//after signin, click on the cart option
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"bd.com.evaly.evalyshop:id"
				+ "/navigation_bar_item_icon_view\"])[3]")).click();
		Thread.sleep(2000);
		
		//cart item is selected or not for check out
		WebElement e = driver.findElement(By.xpath("(//android.view.View[@resource-id=\"bd.com.evaly.evalyshop:id/checkBox\"])[2]"));
		String s = e.getAttribute("checked");
		
		if(s.equalsIgnoreCase("false")==true) {
			System.out.println("All selected...");
			Thread.sleep(1000);
			//click on the checkout option
			driver.findElement(By.id("bd.com.evaly.evalyshop:id/checkoutBtn")).click();
			Thread.sleep(2000);
		}else {
			System.out.println("Not selected... Selecting all..");
			driver.findElement(By.xpath("(//android.view.View[@resource-id=\"bd.com.evaly.evalyshop:id/checkBox\"])[2]")).click();
			Thread.sleep(1000);
			//click on the check out option
			driver.findElement(By.id("bd.com.evaly.evalyshop:id/checkoutBtn")).click();
			Thread.sleep(2000);
		}
		//check out information page before placing order
		String s1 = driver.findElement(By.id("bd.com.evaly.evalyshop:id/btnPlaceOrder")).getText();
		if(s1.equalsIgnoreCase("Place Order")==true) {
			System.out.println("Test passed...");
		}else {
			System.out.println("Test failed...");
		}
	}
}
