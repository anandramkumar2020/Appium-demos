package appiumdemos;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class _001_BasicTest_1 extends _103_ImageBaseTest {

	@Test
	public void successLogin() throws InterruptedException {
		
		System.out.println(">>>>> Inside successLogin");

		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();

		

		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
		driver.findElement(AppiumBy.accessibilityId("Login button")).click();

	}

	@Test
	public void lockedOut() throws InterruptedException {

		System.out.println(">>>>> Inside lockedOut");
		
		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();

		

		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("alice@example.com");
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
		driver.findElement(AppiumBy.accessibilityId("Login button")).click();

	}

}
