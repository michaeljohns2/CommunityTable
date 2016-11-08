package stepdefs;

import com.community.data.EmailRepositoryTest;
import com.community.model.EmailAddressModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by mjohns on 11/5/16.
 */
public class EmailRegisterStepdefs {

    final private static org.slf4j.Logger LOG = LoggerFactory.getLogger(EmailRegisterStepdefs.class);

    /* Use an instance of EmailRepositoryTest to get the Mongo Test Database.
     * This is in-memory and can be static to support multiple operations. */
    final static EmailRepositoryTest repo = new EmailRepositoryTest();

    @When("^I attempt to register (.*)$")
    public void iAttemptToRegister(String email) throws Throwable {
        LOG.debug(String.format("Saving Email ==> %s",email));
        repo.saveEmailInternal(email);
    }

    @Then("^application should have (\\d+) emails$")
    public void applicationShouldHavePlusOneEmails(int plusOne) throws Throwable {
        List<EmailAddressModel> emails = repo.getAllEmails();
        LOG.debug(String.format("All Emails ==> (plusOne of %d)",plusOne));
        emails.forEach( element -> LOG.debug(element.getEmailAddress()));
        assert emails.size() == plusOne;
    }
}
