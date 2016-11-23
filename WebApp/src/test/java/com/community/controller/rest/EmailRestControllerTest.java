package com.community.controller.rest;

import com.community.ApplicationContextConfig;
import com.community.Exceptions.ApiException;
import com.community.Exceptions.ApiServerException;
import com.community.Exceptions.EmailSendException;
import com.community.data.EmailRepositoryTest;
import com.community.model.EmailAddressModel;
import com.community.model.service.MockEmailSender;
import com.community.utils.MessageManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.ResourceBundle;

import static com.community.model.service.MockEmailSender.MOCK_SEND_FAIL_TRIGGER_EMAIL;

/**
 * Created by keljd on 11/6/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class EmailRestControllerTest {

    @Autowired
    EmailRestController controller;

    @Before
    public void injections()
    {
        // This is an example of how to swap the controllers dependency classes for testing.
        ReflectionTestUtils.setField(controller, "emailRepo", new EmailRepositoryTest());
        ReflectionTestUtils.setField(controller, "emailSender", new MockEmailSender());
    }

    @Test
    public void getEmails_EmptyRepo_Test() {
        List<EmailAddressModel> emails = controller.getEmails();
        Assert.assertNotNull(emails);
        Assert.assertTrue(emails.size() == 0);
    }

    @Test
    public void addEmail_AddOne_Test() {

        EmailAddressModel model = controller.addEmail("test@test.com");
        Assert.assertTrue(model != null);
        Assert.assertTrue(model.getEmailAddress().equals("test@test.com"));
        Assert.assertTrue(model.getSecureHash() != null);
    }

    @Test
    public void addEmail_DuplicateEmailAddress_Test() {

        EmailAddressModel model = controller.addEmail("test@test.com");
        Assert.assertTrue(model != null);
        Assert.assertTrue(model.getEmailAddress().equals("test@test.com"));

        try {
            model = controller.addEmail("test@test.com");
        } catch (ApiException ex) {
            Assert.assertEquals(ex.getMessage(), MessageManager.getInstance().getMessage("email.subscribe.duplicate") );
            return;
        }
        Assert.fail("Expected exception.");
    }

    @Test
    public void addEmail_Invalid_Test() {

        try {
            EmailAddressModel model = controller.addEmail("test");
        } catch (ApiException ex) {
            Assert.assertEquals(ex.getMessage(), MessageManager.getInstance().getMessage("email.subscribe.fail_message") );
            return;
        }
        Assert.fail("Expected exception.");
    }

    @Test
    public void addEmail_SendEmailError_Test() {

        try {
            EmailAddressModel model = controller.addEmail(MOCK_SEND_FAIL_TRIGGER_EMAIL);
        } catch (ApiServerException ex) {
            // Commented out specific result test while I am tunneling email error messages.
            //Assert.assertEquals(ex.getMessage(), MessageManager.getInstance().getMessage("email.send.fail") );
            return;
        }
        Assert.fail("Expected API exception on email send.");
    }

}
