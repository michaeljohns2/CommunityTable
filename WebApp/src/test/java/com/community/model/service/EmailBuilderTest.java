package com.community.model.service;

import com.community.Exceptions.InvalidEmailException;
import com.community.Exceptions.TemplateNotFoundException;
import com.community.model.EmailAddressModel;
import com.community.model.EmailModel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by keljd on 11/8/2016.
 */
public class EmailBuilderTest {

    private EmailAddressModel getTestEmail() {
        EmailAddressModel address = new EmailAddressModel();
        address.setEmailAddress("test@test.com");
        address.setSecureHash("somehash");
        return address;
    }

    @Test
    public void buildEmail_Success_Test() {
        EmailBuilder builder = new EmailBuilder();

        EmailModel email = builder.buildEmail(EmailBuilder.EMAIL_TEMPLATE_WELCOME, getTestEmail());

        Assert.assertNotNull(email);
        Assert.assertNotNull(email.getEmailContent());

        // Check for welcome content.
        Assert.assertTrue("Expected welcome message", email.getEmailContent().contains("Welcome"));

        // Check for wrapper content.
        Assert.assertTrue(email.getEmailContent().contains("</html>"));

        // Make sure unsubscribe link was replaced.
        Assert.assertTrue(email.getEmailContent().contains("somehash"));
        Assert.assertTrue(!email.getEmailContent().contains("{$email.unsubscribe.link}"));
    }

    @Test
    public void buildEmail_BadEmail_Test() {
        EmailBuilder builder = new EmailBuilder();
        EmailAddressModel address = getTestEmail();
//        address.setSecureHash(null);//this is getting replaced on get
        address.setEmailAddress(null);

        try {
            EmailModel email = builder.buildEmail("welcomeEmail", address);
        } catch (InvalidEmailException ex) {
            return;  // We expect a failure in this test.
        }

        Assert.fail("Expected an InvalidEmailException.");
    }

    @Test
    public void buildEmail_BadTemplate_Test() {
        EmailBuilder builder = new EmailBuilder();
        try {
            EmailModel email = builder.buildEmail("foo", getTestEmail());
        } catch (TemplateNotFoundException ex) {
            return;  // We expect a failure in this test.
        }

        Assert.fail("Expected a TemplateNotFoundException.");
    }

}
