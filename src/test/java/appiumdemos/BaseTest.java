package appiumdemos;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeTest
    public void setUp() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("testreports/index.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("RE - HMI Test report");
            extent.attachReporter(spark);
        }
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }
}
