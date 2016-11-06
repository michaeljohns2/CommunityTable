package com.community.controller.rest;

import com.community.ApplicationContextConfig;
import com.community.data.EmailRepositoryTest;
import com.community.model.EmailModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
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
        List<EmailModel> emails = controller.getEmails();
        Assert.assertNotNull(emails);
        Assert.assertTrue(emails.size() == 0);
    }
}
