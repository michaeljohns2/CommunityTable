package stepdefs;

import com.community.data.EmailRepositoryTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by mjohns on 11/5/16.
 */
public class EmailRegisterStepdefs {
    /* Use an instance of EmailRepositoryTest to get the Mongo Test Database */
    final EmailRepositoryTest repo;

    public EmailRegisterStepdefs(){
        repo = new EmailRepositoryTest();
    }

    @When("^I attempt to register (.*)$")
    public void iAttemptToRegister(String email) throws Throwable {
        System.out.println("...1.");
        repo.saveEmailInternal(email);
    }

    @Then("^application should have (\\d+) emails$")
    public void applicationShouldHavePlusOneEmails(int plusOne) throws Throwable {
        System.out.println("...2.");
        assert repo.getAllEmails().size() == plusOne;
    }
}
