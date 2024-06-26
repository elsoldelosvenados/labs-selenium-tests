package step_definitions;

import io.cucumber.java8.En;
import pages.Google;

public class GoogleSD implements En {
    Google google;
    public GoogleSD(){

        Given("The user is on the google home page", ()->{
            google = new Google();
            google.navigateToHome();
        });
        When("The user search for the word {string}", (String query) -> {
            System.out.println("Searching for ".concat(query));
        });
        Then("The user should see a list of results related to {string}", (String query) -> {
            System.out.println("Validating results.");
        });
        When("The user filter by using the {string} command", (String command) -> {
            System.out.println("Applying the command ".concat(command));
        });
        Then("The user should only see result of the {string} domain", (String domain) -> {
            System.out.println("Verifying results for the domain ".concat(domain));
        });

    }
}
