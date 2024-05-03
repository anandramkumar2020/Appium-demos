package appiumdemos;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;

public class _008_ImageFunctionalTest extends _103_ImageBaseTest {
	
	public static final String IMAGE_DIR = System.getProperty("user.dir") + "\\Images";
	
	@Test(groups = { "smoke"})
	public void clickLoginButton ()  {
		
		driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.85);

		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();

		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");

		try {
			driver.findElement(AppiumBy.image(getReferenceImageB64())).click();
			System.out.println("Found and clicked Login button");
		} catch (IOException e) {
			System.out.println("Failed to process image: " + e.getMessage());
		}
	}
	
	private String getReferenceImageB64() throws IOException {
		String filePath = IMAGE_DIR+"\\Loginbutton.png";
		File refImgFile = new File(filePath);

		if (!refImgFile.exists()) {
			throw new FileNotFoundException("Image file not found: " + filePath);
		}
		return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
	}
}
