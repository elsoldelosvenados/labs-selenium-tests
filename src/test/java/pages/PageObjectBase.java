package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class PageObjectBase {
    public static WebDriver driver;
    private static ExtentReports extent;

    private static ExtentSparkReporter extentSparkReporter;
    private static ExtentTest test;

    private static final Logger logger =  Logger.getLogger(PageObjectBase.class.getName());

    static {
        try{
            extentSparkReporter = new ExtentSparkReporter("report.html");
            extentSparkReporter.config().setTimelineEnabled(true);
            extent = new ExtentReports();
            extent.attachReporter(extentSparkReporter);
            extent.setSystemInfo("Clave","Valor");
            extent.setSystemInfo("Clave2", "valor2");
            extentSparkReporter.config().setDocumentTitle("Lover land");
            test = extent.createTest("Este es el nombre del test");
            test.assignAuthor("Andres macbook");
            driver =  new ChromeDriver();
        }catch (Exception exception){
            logger.warning("There was an error while initiating the page object base. "  + exception.getMessage());
        }
    }

    protected void info(String message, String base64IMG){
        test.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64IMG).build());
    }
    protected void error(String message){
        test.fail(message);
    }
    public static void reportEnd(){
        extent.flush();
    }
}
