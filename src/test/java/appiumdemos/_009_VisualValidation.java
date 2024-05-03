///**
// * This class contains a visual validation test for the login screen of an application.
// * It extends the _103_ImageBaseTest class to utilize the Android driver for image comparison.
// */
//package appiumdemos;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.openqa.selenium.OutputType;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
//import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
//
//public class _009_VisualValidation extends _103_ImageBaseTest {
//
//	private ExtentTest test;
//
//	// Threshold for similarity match
//	private static final double MATCH_THRESHOLD = 0.99;
//	// Directory path for storing images
//	private static final String IMAGE_DIR = System.getProperty("user.dir") + "\\Images";
//
//	/**
//	 * Test method for performing visual validation of the login screen.
//	 * 
//	 * @throws Exception If an error occurs during test execution.
//	 */
//	@Test(groups = { "smoke" })
//	public void testAppDesign() throws Exception {
//
//		test = extent.createTest("Login screen app design").assignAuthor("Anand Ramkumar").assignCategory("Smoke")
//				.assignCategory("Regression").assignDevice("Alpine Electronics");
//
//		// Open Login screen
//		test.pass("Visual validation started successfully");
//		Thread.sleep(5000);
//		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
//		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
//		test.info("Login screen loaded");
//
//		driver.findElement(AppiumBy.accessibilityId("Username input field"));
//
//		// Perform visual check
//		test.info("Performing visualcheck");
//		doVisualCheck();
//
//	}
//
//	/**
//	 * Method to perform visual check of the login screen.
//	 * 
//	 * @throws IOException If an I/O error occurs.
//	 */
//	private void doVisualCheck() throws IOException {
//
//		String baselineFilename = IMAGE_DIR + "\\LoginScreen.png";
//		File baselineImg = new File(baselineFilename);
//		SimilarityMatchingResult res = null;
//
//		// Image similarity from Appium.
//		// Turn on visualization so we can see what went wrong (delta)
//		SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
//		opts.withEnabledVisualization();
//
//		try {
//			// Compare the baseline image with the current screenshot
//			res = driver.getImagesSimilarity(baselineImg, driver.getScreenshotAs(OutputType.FILE), opts);
//		} catch (IOException e) {
//			System.out.println("Failed to get baseline image: " + e.getMessage());
//		}
//		System.out.println("Similarity Score" + res.getScore());
//		test.info("Similarity scrore " + res.getScore());
//
//		// Check fails if it is below match threshold
//		if (res.getScore() < MATCH_THRESHOLD) {
//			// Store visualization of failed comparison
//			File failViz = new File(IMAGE_DIR + "\\CheckFailed_LoginScreen.png");
//			res.storeVisualization(failViz);
//
//			String vizResult = String.format(
//					"Visual check of screen failed; similarity match was only %f, and below the threshold of %f. Visualization written to %s.",
//					res.getScore(), MATCH_THRESHOLD, failViz.getAbsolutePath());
//
//			test.info("Visual check of login screen completed");
//
//			test.fail("screen comparison failed", MediaEntityBuilder
//					.createScreenCaptureFromPath(getImagePath("CheckFailed_LoginScreen.png")).build());
//
//			// Assert fail and stop the test
//			Assert.fail("Visual check failed >>> : " + vizResult);
//
//		} else {
//			// Print visualization result and assert pass
//			String vizResult = String.format("Visual check of screen passed; similarity match was only %f",
//					res.getScore());
//			System.out.println(vizResult);
//			test.info("Visual check of login screen completed");
//			test.pass("screen comparison passed");
//			// Assert pass
//			Assert.assertTrue(true, "Visual check passed : " + vizResult);
//
//		}
//	}
//
//	private String getImagePath(String imageName) {
//		// Get the absolute path of the "Images" folder
//		String imagesFolder = new File("Images").getAbsolutePath();
//		System.out.println("Imagefolder >>>> " + imagesFolder);
//
//		// Combine the folder path with the image name
//		return new File(imagesFolder, imageName).getAbsolutePath();
//	}
//}

/**
 * This class contains a visual validation test for the login screen of an application.
 * It extends the _103_ImageBaseTest class to utilize the Android driver for image comparison.
 */
package appiumdemos;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;

public class _009_VisualValidation extends _103_ImageBaseTest {

    // ExtentTest object for reporting
    private ExtentTest test;

    // Threshold for similarity match
    private static final double MATCH_THRESHOLD = 0.97;
    // Directory path for storing images
    private static final String IMAGE_DIR = System.getProperty("user.dir") + "\\Images";
    
    
    /**
     * Test method for performing visual validation of the login screen.
     * 
     * @throws Exception If an error occurs during test execution.
     */
    @Test(groups = { "smoke" })
    public void testAppDesign() throws Exception {

        // Create ExtentTest instance for reporting
        test = extent.createTest("Login screen app design")
            .assignAuthor("Anand Ramkumar")
            .assignCategory("Smoke")
            .assignCategory("Regression")
            .assignDevice("Alpine Electronics");

        // Open Login screen
        test.pass("Visual validation started successfully");
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        test.info("Login screen loaded");

        driver.findElement(AppiumBy.accessibilityId("Username input field"));

        // Perform visual check
        test.info("Performing visualcheck");
        doVisualCheck();
    }

    /**
     * Method to perform visual check of the login screen.
     * 
     * @throws IOException If an I/O error occurs.
     */
    private void doVisualCheck() throws IOException {

        // Baseline image file
        String baselineFilename = IMAGE_DIR + "\\LoginScreen.png";
        File baselineImg = new File(baselineFilename);
        SimilarityMatchingResult res = null;

        // Image similarity options
        SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
        opts.withEnabledVisualization();

        try {
            // Compare the baseline image with the current screenshot
            res = driver.getImagesSimilarity(baselineImg, driver.getScreenshotAs(OutputType.FILE), opts);
        } catch (IOException e) {
            System.out.println("Failed to get baseline image: " + e.getMessage());
        }
        System.out.println("Similarity Score" + res.getScore());
        test.info("Similarity scrore " + res.getScore());

        // Check fails if it is below match threshold
        if (res.getScore() < MATCH_THRESHOLD) {
            // Store visualization of failed comparison
            File failViz = new File(IMAGE_DIR + "\\CheckFailed_LoginScreen.png");
            res.storeVisualization(failViz);

            String vizResult = String.format(
                    "Visual check of screen failed; similarity match was only %f, and below the threshold of %f. Visualization written to %s.",
                    res.getScore(), MATCH_THRESHOLD, failViz.getAbsolutePath());

            test.info("Visual check of login screen completed");

            // Fail test and attach screenshot
            test.fail("screen comparison failed", MediaEntityBuilder
                    .createScreenCaptureFromPath(getImagePath("CheckFailed_LoginScreen.png")).build());

            // Assert fail and stop the test
            Assert.fail("Visual check failed >>> : " + vizResult);

        } else {
            // Print visualization result and assert pass
            String vizResult = String.format("Visual check of screen passed; similarity match was only %f",
                    res.getScore());
            System.out.println(vizResult);
            test.info("Visual check of login screen completed");
            test.pass("screen comparison passed");
            // Assert pass
            Assert.assertTrue(true, "Visual check passed : " + vizResult);

        }
    }

    /**
     * Method to get the absolute path of an image in the Images folder.
     * 
     * @param imageName The name of the image file.
     * @return The absolute path of the image file.
     */
    private String getImagePath(String imageName) {
        // Get the absolute path of the "Images" folder
        String imagesFolder = new File("Images").getAbsolutePath();
        System.out.println("Imagefolder >>>> " + imagesFolder);

        // Combine the folder path with the image name
        return new File(imagesFolder, imageName).getAbsolutePath();
    }
}

