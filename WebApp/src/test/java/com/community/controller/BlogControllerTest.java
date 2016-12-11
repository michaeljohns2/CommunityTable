package com.community.controller;

import com.community.ApplicationContextConfig;
import com.community.data.BlogRepositoryTest;
import com.community.data.EmailRepositoryTest;
import com.community.model.service.MockEmailSender;
import com.community.utils.TestModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import java.util.Map;

/**
 * Created by keljd on 12/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class BlogControllerTest {

    @Autowired
    BlogController controller;

    @Before
    public void injections()
    {
        // This is an example of how to swap the controllers dependency classes for testing.
        ReflectionTestUtils.setField(controller, "blogRepo", new BlogRepositoryTest());
    }

    @Test
    public void displayBlogEntries_Test() {
        TestModel model = new TestModel();

        String view = controller.displayBlogEntries(model);
        Map<String, Object> attributes = model.asMap();
        Assert.assertNotNull(attributes.get("blogList"));
    }

    @Test
    public void displayBlogEntry_Test() {
        TestModel model = new TestModel();
        String view = controller.displayBlogEntry("foo", model);
        Assert.assertTrue(view.equals("blogNotFound"));
    }
}
