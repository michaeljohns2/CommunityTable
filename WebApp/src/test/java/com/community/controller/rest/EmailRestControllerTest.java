package com.community.controller.rest;

import com.community.ApplicationContextConfig;
import com.community.Exceptions.ApiException;
import com.community.data.EmailRepositoryTest;
import com.community.model.EmailAddressModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

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
    public void addEmail_DuplicateEmail_Test() {
        EmailAddressModel model = controller.addEmail("test@test.com");
        Assert.assertTrue(model != null);
        Assert.assertTrue(model.getEmailAddress().equals("test@test.com"));

        try {
            model = controller.addEmail("test@test.com");
        } catch (ApiException ex) {
            Assert.assertEquals(ex.getMessage(), EmailRestController.EMAIL_EXISTS_MESSAGE );
            return;
        }
        Assert.fail("Expected exception.");
    }

    @Test
    public void addEmail_Invalid_Test() {
        try {
            EmailAddressModel model = controller.addEmail("test");
        } catch (ApiException ex) {
            Assert.assertEquals(ex.getMessage(), EmailRestController.EMAIL_INVALID_MESSAGE );
            return;
        }
        Assert.fail("Expected exception.");
    }

}
