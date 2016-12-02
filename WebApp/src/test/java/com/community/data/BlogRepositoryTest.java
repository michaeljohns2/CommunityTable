package com.community.data;

import com.community.model.BlogModel;
import com.community.utils.ConfigManager;
import com.github.fakemongo.junit.FongoRule;
import com.mongodb.client.MongoDatabase;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Extends BlogRepository to supply a fongo instance for tests.
 */
public class BlogRepositoryTest extends BlogRepository {

    final private static org.slf4j.Logger LOG = LoggerFactory.getLogger(BaseRepositoryTest.class);

    @Rule
    public FongoRule fongoRule = new FongoRule();//allows swapping to localhost if needed.

    @Override
    public MongoDatabase getMongoDatabase() {
        //Override to use fongo database
        return fongoRule.getFongo().getDatabase(ConfigManager.getInstance().getSetting(ConfigManager.DB_NAME_KEY));
    }

    @Test
    public void saveBlogTest() {
        try {
            BlogModel blog = new BlogModel();
            blog.setSubject("Test subject");
            blog.setBody("Sample blog body foo bacon Sample blog body foo bacon Sample " +
                    "blog body foo bacon Sample blog body foo bacon Sample blog body foo bacon ");

            blog.setCreatedDate(new Date());
            this.saveBlogEntry(blog);
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

}
