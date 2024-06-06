package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class PageObjectBase {
    public static WebDriver driver;

    private static final Logger logger =  Logger.getLogger(PageObjectBase.class.getName());

    static {
        try{
            driver =  new ChromeDriver();
        }catch (Exception exception){
            logger.warning("There was an error while initiating the page object base.");
        }
    }
}
