package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features-files",
        glue = "step_definitions",
        tags = "@Search"
)
public class RunCucumberTest {
}
