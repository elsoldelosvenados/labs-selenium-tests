package step_definitions;

import io.cucumber.java8.En;
import org.junit.Before;
import pages.PageObjectBase;

public class Hooks implements En {
    public Hooks(){
        After(()->{
            PageObjectBase.driver.quit();
        });
    }
}
