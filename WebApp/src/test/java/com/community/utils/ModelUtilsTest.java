package com.community.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.Model;

/**
 * Created by keljd on 12/11/2016.
 */
public class ModelUtilsTest {

    @Test
    public void ModelUtils_addCommonAttrs_Test() {
        TestModel model = new TestModel();
        ModelUtils.addCommonAttrs(model);
        Assert.assertTrue(model.containsAttribute("nav_title_1"));
        Assert.assertTrue(model.containsAttribute("title"));
    }

    @Test
    public void ModelUtils_addCommonAdminAttrs_Test() {
        TestModel model = new TestModel();
        ModelUtils.addHeaderAttrs(model);
        Assert.assertTrue(model.containsAttribute("title"));
    }

}
