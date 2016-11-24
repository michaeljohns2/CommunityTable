package com.community.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mjohns on 11/23/16.
 */
public class StrPairTest {

    @Test
    public void pair_Test() {

        Assert.assertTrue("Expected with null s1s to equal true", StrPair.of(null,"s2").equals(StrPair.of(null,"s2")));
        Assert.assertTrue("Expected with null s2s to equal true", StrPair.of("s1",null).equals(StrPair.of("s1",null)));
        Assert.assertTrue("Expected with both nulls to equal true", StrPair.of(null,null).equals(StrPair.of(null,null)));

        Assert.assertTrue("Expected with s1s and s2s to equal true", StrPair.of("s1","s2").equals(StrPair.of("s1","s2")));
        Assert.assertFalse("Expected with non-matching s1s to equal false", StrPair.of("s","s2").equals(StrPair.of("s1","s2")));
        Assert.assertFalse("Expected with non-matching s2s to equal false", StrPair.of("s1","s").equals(StrPair.of("s1","s2")));
    }
}
