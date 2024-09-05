package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.logging.Logger;

public class Google extends PageObjectBase {

    private final Logger logger = Logger.getLogger(Google.class.getName());

    public void navigateToHome() {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.get("https://google.com");
            Thread.sleep(3000);
            logger.info("INSIDE THE CHROME INSTANCE.");
            info("This is the google home", ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
        } catch (Exception exception) {
            error("There was an error while navigation to the google home. " + exception.getMessage());
        }
    }


}
