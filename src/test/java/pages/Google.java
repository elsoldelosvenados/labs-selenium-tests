package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.Logger;

public class Google extends PageObjectBase {

    private final Logger logger =  Logger.getLogger(Google.class.getName());
    public void navigateToHome(){
        try{
           driver.get("https://google.com");
           Thread.sleep(3000);
           info("This is the google home", ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64));
        }catch (Exception exception){
            error("There was an error while navigation to the google home. " + exception.getMessage());
        }
    }


}
