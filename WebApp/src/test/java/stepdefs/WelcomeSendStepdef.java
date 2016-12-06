package stepdefs;

import com.community.controller.rest.EmailRestController;
import com.community.data.EmailRepositoryTest;
import com.community.model.service.EmailBuilder;
import com.community.model.service.MockEmailSender;
import com.community.utils.MessageManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.slf4j.LoggerFactory;

/**
 * Created by mjohns on 11/27/16.
 */
public class WelcomeSendStepdef {

    final private static org.slf4j.Logger LOG = LoggerFactory.getLogger(WelcomeSendStepdef.class);


    final private static EmailRestController controller = new EmailRestController();
    static {
        controller.useEmailBuilder(new EmailBuilder());
        controller.useEmailSender(new MockEmailSender());
        controller.useEmailRepo(new EmailRepositoryTest());
        controller.useMessageManager(MessageManager.getInstance());
    }

    static String lastEmail = "";
    static String lastWelcome = "";

    @When("^User successfully registers (.*)$")
    public void userSuccessfullyRegistersEmail(String email) throws Throwable {
        LOG.debug(String.format("lastEmail set to ==> %s",email));
        lastEmail = email;

        try {
            controller.addEmail(email);
            lastWelcome = "welcome";
        } catch (Exception e){
//            e.printStackTrace();
            lastWelcome = e.getMessage();
        }

        LOG.debug(String.format("(lastWelcome set to ==> %s",lastWelcome));
    }

    @Then("^application should send a (.*) email if valid and not duplicate$")
    public void WelcomeSendStepdef(String isWelcome) throws Throwable {

        boolean is = Boolean.parseBoolean(isWelcome);
        LOG.debug(String.format("is welcome ==> %b",is));

        if (is)
            assert lastWelcome.equals("welcome");
        else
            assert !lastWelcome.equals("welcome");
    }
}
