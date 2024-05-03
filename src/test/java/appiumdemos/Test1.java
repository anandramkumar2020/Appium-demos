package appiumdemos;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

public class Test1 extends BaseTest {

    @Test
    public void extentTest() {
        ExtentTest test = extent.createTest("Login Test")
            .assignAuthor("Anand Ramkumar")
            .assignCategory("Smoke")
            .assignCategory("Regression")
            .assignDevice("Alpine Electronics");
        test.pass("Login test started successfully");
        test.info("URL is loaded");
        test.info("Credentials entered");
        test.pass("Login test completed successfully");
    }
}
