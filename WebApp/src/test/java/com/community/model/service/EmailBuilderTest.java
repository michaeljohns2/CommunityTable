package com.community.model.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by keljd on 11/8/2016.
 */
public class EmailBuilderTest {

    @Test
    public void buildEmail_Success_Test() {
        EmailBuilder builder = new EmailBuilder();
        String email = builder.buildEmail(EmailBuilder.EMAIL_TEMPLATE_WELCOME);

        Assert.assertNotNull(email);

        // Check for welcome content.
        Assert.assertTrue(email.contains("Welcome"));

        // Check for wrapper content.
        Assert.assertTrue(email.contains("</html>"));
    }

    @Test
    public void buildEmail_BadTemplate_Test() {
        EmailBuilder builder = new EmailBuilder();
        try {
            String email = builder.buildEmail("foo");
        } catch (Exception ex) {
            return;  // We expect a failure in this test.
        }

        Assert.fail("Expected a TemplateNotFoundException.");
    }

}
