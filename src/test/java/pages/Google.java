package pages;

import java.util.logging.Logger;

public class Google extends PageObjectBase {

    private final Logger logger =  Logger.getLogger(Google.class.getName());
    public void navigateToHome(){
        try{
           driver.get("https://google.com");
           Thread.sleep(3000);
        }catch (Exception exception){
            logger.warning("There was an error while navigation to the google home.");
        }
    }


}
