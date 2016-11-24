package com.community.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.MissingResourceException;

/**
 * Created by mjohns on 11/23/16.
 */
public class MessageManagerTest {

    @Test
    public void pair_Test() {

        MessageManager mgr = MessageManager.getInstance();

        //Generic testing
        String param1 = "param1";
        String param2 = "param2";
        String msg0Param = "the rain in spain stays mainly in the plain.";
        String msg1Param = msg0Param.replace("plain","{$param1}");
        String msg2Params = msg1Param.replace("spain","{$param2}");
        StrPair[] pairs = new StrPair[]{StrPair.of(param1,"plain"),StrPair.of(param2,"spain")};

        Assert.assertEquals("Expect no replacement",mgr.messageReplacement(msg0Param,StrPair.of(param1,"NADA")), msg0Param);
        Assert.assertEquals("Expect no replacement",mgr.messageReplacement(msg0Param,pairs[0]), msg0Param);
        Assert.assertEquals("Expect replacement of 1 param",mgr.messageReplacement(msg1Param,pairs[0]), msg0Param);
        Assert.assertEquals("Expect replacement of 2 params",mgr.messageReplacement(msg2Params,pairs), msg0Param);

        //Email replacement within message testing
        String emailParam = "site.email";
        String emailVal = "info@communitytabletn.com";

        String emailMsgTemplate = "We are members of the community who want to make the community stronger. You can contact the " +
                "Director at <a href=\"mailto:{$"+emailParam+"}?Subject=Contact%20page\" target=\"_top\">{$"+emailParam+"}</a>";

        String emailExpected = emailMsgTemplate.replace(String.format("{$%s}",emailParam),emailVal);

        Assert.assertEquals("Expect 2 email replacements",mgr.messageReplacement(
                emailMsgTemplate,StrPair.of(emailParam,emailVal)), emailExpected);
    }

    @Test
    public void message_Test() {

        MessageManager mgr = MessageManager.getInstance();

        Assert.assertNotNull("brand should not be null",mgr.getMessage("brand"));

        try {
            mgr.getMessage("a non existing token");
        } catch (MissingResourceException ex) {
            return;  // We expect a failure in this test.
        }

        Assert.fail("Expected a MissingResourceException.");
    }
}
