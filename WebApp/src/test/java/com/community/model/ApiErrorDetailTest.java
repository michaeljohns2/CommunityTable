package com.community.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by keljd on 12/11/2016.
 */
public class ApiErrorDetailTest {

    @Test
    public void ApiErrorDetailTest_setter_getter_test() {
        String message = "This is a unit test";
        ApiErrorDetail error = new ApiErrorDetail();
        error.setMessage(message);

        Assert.assertTrue(message.equals(error.getMessage()));
    }
}
