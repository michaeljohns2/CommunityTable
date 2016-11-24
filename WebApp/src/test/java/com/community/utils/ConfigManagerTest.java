package com.community.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.MissingResourceException;

/**
 * Created by mjohns on 11/23/16.
 */
public class ConfigManagerTest {

    @Test
    public void message_Test() {

        ConfigManager mgr = ConfigManager.getInstance();

        Assert.assertNotNull("mongo server key should not be null",mgr.getSetting(ConfigManager.MONGO_SERVER_KEY));

        try {
            mgr.getSetting("a non existing token");
        } catch (MissingResourceException ex) {
            return;  // We expect a failure in this test.
        }

        Assert.fail("Expected a MissingResourceException.");
    }
}
