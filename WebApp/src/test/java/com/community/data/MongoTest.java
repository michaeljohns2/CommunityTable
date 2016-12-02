package com.community.data;

import com.community.InstanceTestClassListener;
import com.community.utils.Base64Utils;
import com.github.fakemongo.Fongo;
import com.github.fakemongo.junit.FongoRule;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * CommunityTable Mongo Test Suite.
 * Uses custom instance test runner for object (not static)
 * setup and tear-down.
 *
 * Fongo used to mock.
 * See https://github.com/fakemongo/fongo
 *
 * @author mjohns
 */
public class MongoTest implements InstanceTestClassListener {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MongoTest.class);

    @Rule
    public FongoRule fongoRule = new FongoRule();//allows swapping to localhost if needed.

    protected Fongo fongo = null;
    protected String dbName = "testDb";
    protected String collectionName = "community";

    /* once you have a DB instance, you can interact with it
       just like you would with a real one. */
    protected MongoDatabase db = null;

    public void beforeClassSetup() throws Exception {
        //anything?
    }

    public void afterClassSetup() {
        //get hook from fongoRule and drop database
        fongo = fongoRule.getFongo();
        fongo.dropDatabase(dbName);
    }

    @Before
    public void beforeMethod(){
        //get hook from fongoRule for test
        fongo = fongoRule.getFongo();
        db = fongo.getDatabase(dbName);

        assertTrue("Expected fong instance not null",fongo != null);
        assertTrue("Expected db instance not null",db != null);
    }

    @Test
    public void mongoInsertTest() {
        try {
            MongoCollection<Document> collection = db.getCollection(collectionName);
            assertTrue(String.format("Expected collection '%s' to exist", collectionName), collectionName != null);
            collection.insertOne(new Document("name", "jon"));

            long expected = 1;
            long actual = collection.count();
            assertEquals(String.format("Expected collection '%s' to have %d objects, actuals was %d", collectionName, expected, actual), expected, actual);
        } catch (Exception e){
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void mongoImageTest(){
        try {
            //NOTICE HOW BSON DOCUMENT IS USED HERE!!!
            //SEE http://mongodb.github.io/mongo-java-driver/3.2/driver-async/reference/crud/
            MongoCollection<BsonDocument> collection = db.getCollection(collectionName,BsonDocument.class);
            assertTrue(String.format("Expected collection '%s' to exist", collectionName), collectionName != null);

            Path img = Paths.get("","src","test","resources","test.png").toAbsolutePath();
            LOG.info(String.format("...img path '%s'",img.toString()));

            //encode image
            String b64 = Base64Utils.encode(img);
            LOG.info(String.format("BASE64 ==> %s",b64));

            //prep bson document
            BsonDocument bDoc = new BsonDocument()
                    .append("comment", new BsonString("This is our ci/cd process image."))
                    .append("filename", new BsonString("ci_cd.png"))
                    .append("b64", new BsonBinary(b64.getBytes()));

            LOG.info(String.format("BSON DOCUMENT ==> %s",bDoc));

            //insert into mongo
            collection.insertOne(bDoc);
            assertEquals(collection.count(),1);

            //get back from mongo
            FindIterable<BsonDocument> results = collection.find(bDoc);//using bDoc provided as filter
            BsonDocument r  = null;
            for (BsonDocument bd : results)
                r = bd;//only 1

            assertEquals(bDoc.get("filename"),r.get("filename"));

        } catch (Exception e){
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }
}