package appiumdemos;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.io.File;

public class Test2 extends BaseTest {

    @Test
    public void extentTest() {
        ExtentTest test1 = extent.createTest("Home Page Test")
            .assignAuthor("Joe Smith")
            .assignCategory("Regression")
            .assignDevice("Panasonic Automotive");
        test1.pass("Home Page test started successfully");
        test1.info("URL is loaded");
        test1.info("Credentials entered");
        test1.fail("Home Page test failed", 
            MediaEntityBuilder.createScreenCaptureFromPath(getImagePath("CheckFailed_LoginScreen.png")).build());
    }

    private String getImagePath(String imageName) {
        // Get the absolute path of the "Images" folder
        String imagesFolder = new File("Images").getAbsolutePath();
        System.out.println("Imagefolder >>>> " + imagesFolder);
        
        // Combine the folder path with the image name
        return new File(imagesFolder, imageName).getAbsolutePath();
    }
}
