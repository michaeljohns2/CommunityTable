package com.community.utils;

import com.community.data.MongoTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

/**
 * Created by mjohns on 12/1/16.
 */
public class Base64UtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(MongoTest.class);

    @Test
    public void encodeTest(){

        try{
            Path img = Paths.get("","src","test","resources","test.png").toAbsolutePath();
            LOG.info(String.format("...img path '%s'",img.toString()));

            //encode image
            String b64 = Base64Utils.encode(img);
            LOG.info(String.format("BASE64 ==>%s",b64));

            //verify image
            byte[] orig = Files.readAllBytes(img);//read bytes for the original
            byte[] out = Base64Utils.decode(b64);//decode the b64 back

            assertArrayEquals(orig,out);

        } catch (Exception e){
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }
}
