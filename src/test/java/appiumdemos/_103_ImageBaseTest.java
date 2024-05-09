/**
 * This class represents the base test class for image-based tests in the Appium demos.
 * It initializes and tears down the Android driver for running tests on the specified app.
 */
package appiumdemos;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class _103_ImageBaseTest {

	protected static ExtentReports extent;
	protected ExtentTest test;

	// Declare the AndroidDriver instance
	public AndroidDriver driver;

	/**
	 * This method sets up the Android driver before each test method.
	 * 
	 * @throws MalformedURLException If the URL for Appium server is invalid.
	 * @throws InterruptedException  If the thread is interrupted while waiting.
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws MalformedURLException, InterruptedException {

		if (extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("testreports/index.html");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("RE - HMI Test report");
			extent.attachReporter(spark);
		}

		// Define the desired capabilities and options for the Android driver
		UiAutomator2Options options = new UiAutomator2Options()
				.setApp("/home/anand/Documents/apps/Android-MyDemoAppRN.1.3.0.build-244.apk")
				.setAppPackage("com.saucelabs.mydemoapp.rn").setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity")
				.setAutomationName("UIAutomator2");

		

		// Initialize the Android driver with the specified options and Appium server
		// URL
		driver = new AndroidDriver(new URL("http://192.168.1.10:4723"), options);
		//driver = new AndroidDriver(new URL("http://172.20.10.7:4723"), options);
	}

	/**
	 * This method tears down the Android driver after each test method.
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Quit the Android driver
		driver.quit();

		extent.flush();

	}
}
