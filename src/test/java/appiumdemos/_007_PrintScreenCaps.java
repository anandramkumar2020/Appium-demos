package appiumdemos;

import org.openqa.selenium.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class _007_PrintScreenCaps extends _103_ImageBaseTest {

	public static final String IMAGE_DIR = System.getProperty("user.dir") + "\\Images";

	//@Test(groups = { "smoke"})
	public void elementScreenShot() throws InterruptedException, IOException {

		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();

		driver.findElement(AppiumBy.accessibilityId("Username input field"));
		driver.findElement(AppiumBy.accessibilityId("Password input field"));
		WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));
		takeElementScreenShot(driver, loginButton);

	}

	@Test(groups = { "smoke"})
	public void fullScreenShot() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
		
		Thread.sleep(3000);

		driver.findElement(AppiumBy.accessibilityId("Username input field"));
		driver.findElement(AppiumBy.accessibilityId("Password input field"));
		driver.findElement(AppiumBy.accessibilityId("Login button"));
		
		Thread.sleep(3000);

		// Take Screenshot
		try {
			// Cast the driver to TakesScreenshot
			TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

			// Get the screenshot as a file
			File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

			// Define the destination path for the screenshot
			String screenshotPath = IMAGE_DIR + "\\LoginScreen.png";

			// Save the screenshot to the specified path
			FileHandler.copy(screenshotFile, new File(screenshotPath));

			System.out.println("Screenshot saved at: " + screenshotPath);

		} catch (WebDriverException e) {
			System.out.println("Failed to cast driver: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Failed to take screenshot: " + e.getMessage());
		}

	}

	private void takeElementScreenShot(AndroidDriver driver, WebElement ele) {

		File screenshotLocation = null;

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			BufferedImage fullImg = ImageIO.read(scrFile);

			// Get the location of element on the page
			Point point = ele.getLocation();

			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", scrFile);
			String path = IMAGE_DIR +"\\element_"+UUID.randomUUID()+".png";

			
			screenshotLocation = new File(path);
			FileUtils.copyFile(scrFile, screenshotLocation);
			
			System.out.println(screenshotLocation.toString());

		} catch (Exception e) {
			System.out.println("Failed to take element screenshot: " + e.getMessage());
		}

	}
}