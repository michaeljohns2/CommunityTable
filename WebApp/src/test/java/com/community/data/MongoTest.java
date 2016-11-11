package com.community.data;

import com.community.InstanceTestClassListener;
import com.github.fakemongo.Fongo;
import com.github.fakemongo.junit.FongoRule;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.LoggerFactory;

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
}