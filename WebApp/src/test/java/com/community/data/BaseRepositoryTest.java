package com.community.data;

import com.github.fakemongo.junit.FongoRule;
import com.mongodb.client.MongoDatabase;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by mjohns on 11/5/16.
 * Extends BaseRepository to supply a fongo instance for tests.
 *
 */
public class BaseRepositoryTest extends BaseRepository {

    final private static org.slf4j.Logger LOG = LoggerFactory.getLogger(BaseRepositoryTest.class);

    @Rule
    public FongoRule fongoRule = new FongoRule();//allows swapping to localhost if needed.

    @Override
    public MongoDatabase getMongoDatabase() {
        //Override to use fongo database
        return fongoRule.getFongo().getDatabase(DB_NAME);
    }

    @Test
    public void connectionTest(){
        try {
            MongoDatabase db = getMongoDatabase();

            assertNotNull("Expected mongoServerName to not be null", mongoServerName != null);
            assertNotNull("Expected getMongoDatabase() result to not be null", db != null);
            assertTrue("Expected available databases to be 1", fongoRule.getFongo().getDatabaseNames().size() == 1);
        } catch(Exception e){
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }
}
