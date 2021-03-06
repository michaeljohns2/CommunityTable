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

    private String testSubject = "Test subject";
    private String testBody = "Sample blog body foo bacon Sample blog body foo bacon Sample " +
            "blog body foo bacon Sample blog body foo bacon Sample blog body foo bacon ";

    private String testSubject2 = "Test subject2";
    private String testBody2 = "Sample blog body foo bacon Sample blog body foo bacon Sample " +
            "blog body foo bacon Sample blog body foo bacon Sample blog body foo bacon2 ";

    private String testFeaturedImg = "";

    @Test
    public void saveBlogTest() {
        try {
            BlogModel blog = new BlogModel();
            blog.setSubject("Test subject");
            blog.setBody("Sample blog body foo bacon Sample blog body foo bacon Sample " +
                    "blog body foo bacon Sample blog body foo bacon Sample blog body foo bacon ");
            blog.setFeaturedImg(testFeaturedImg);
            blog.setCreatedDate(new Date());
            this.saveBlogEntry(blog);
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void getBlogTest() {
        try {
            BlogModel blog = new BlogModel();
            blog.setSubject(testSubject);
            blog.setBody(testBody);
            blog.setFeaturedImg(testFeaturedImg);
            blog.setCreatedDate(new Date());
            this.saveBlogEntry(blog);

            List<BlogModel> blogs = this.getAllBlogs();
            assertTrue(blogs.size() == 1);
            BlogModel blogEntry1 = blogs.get(0);
            String id = blogEntry1.getBlogId();

            BlogModel blogEntry2 = this.getBlog(id);
            assertTrue(blogEntry2!=null);
            assertTrue(blogEntry2.getBody()!=null);

            assertTrue(blogEntry2.getSubject().equals(testSubject));
            assertTrue(blogEntry2.getBody().equals(testBody));

        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }


    @Test
    public void getNonExistentBlogTest() {
        try {
            BlogModel blog = new BlogModel();
            blog.setSubject(testSubject);
            blog.setBody(testBody);
            blog.setFeaturedImg(testFeaturedImg);
            blog.setCreatedDate(new Date());
            this.saveBlogEntry(blog);


            BlogModel blogEntry2 = this.getBlog("");
            assertNull(blogEntry2);

        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void getBlogsTest() {
        try {
            BlogModel blog = new BlogModel();
            blog.setSubject(testSubject);
            blog.setBody(testBody);
            blog.setFeaturedImg(testFeaturedImg);
            blog.setCreatedDate(new Date());
            this.saveBlogEntry(blog);

            List<BlogModel> blogs = this.getAllBlogs();
            assertTrue(blogs.size() == 1);

            BlogModel blogEntry = blogs.get(0);
            assertTrue(blogEntry.getSubject().equals(testSubject));
            assertTrue(blogEntry.getBody().equals(testBody));

        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void getBlogsMultipleTest() {
        try {
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

            BlogModel blog = new BlogModel();
            blog.setSubject(testSubject);
            blog.setBody(testBody);
            blog.setFeaturedImg(testFeaturedImg);
            Date dt = ft.parse("2016-12-01");
            blog.setCreatedDate(dt);
            this.saveBlogEntry(blog);

            BlogModel blog2 = new BlogModel();
            blog2.setSubject(testSubject2);
            blog2.setBody(testBody2);
            blog2.setFeaturedImg(testFeaturedImg);
            Date dt2 = ft.parse("2016-12-02");
            blog2.setCreatedDate(dt2);
            this.saveBlogEntry(blog2);

            List<BlogModel> blogs = this.getAllBlogs();
            assertTrue(blogs.size() == 2);

            BlogModel blogEntry = blogs.get(0);
            assertTrue(blogEntry.getSubject().equals(testSubject2));
            assertTrue(blogEntry.getBody().equals(testBody2));

            BlogModel blogEntry2 = blogs.get(1);
            assertTrue(blogEntry2.getSubject().equals(testSubject));
            assertTrue(blogEntry2.getBody().equals(testBody));

        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteBlogsTest() {
        try {
            BlogModel blog = new BlogModel();
            blog.setSubject("Test subject");
            blog.setBody("body");
            blog.setFeaturedImg(testFeaturedImg);
            blog.setCreatedDate(new Date());
            this.saveBlogEntry(blog);

            List<BlogModel> blogs = this.getAllBlogs();
            assertTrue(blogs.size() == 1);
            blog = blogs.get(0);

            // Ensure blog was deleted.
            this.deleteBlog(blog.getBlogId());
            blogs = this.getAllBlogs();
            assertTrue(blogs.size() == 0);

        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            fail(e.getMessage());
        }
    }
}
