package stepdefs;

import com.community.data.BlogRepositoryTest;
import com.community.model.BlogModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by mjohns on 12/12/16.
 */
public class BlogPreviewStepdef {

    final private static org.slf4j.Logger log = LoggerFactory.getLogger(BlogPreviewStepdef.class);

    /* Use an instance of BlogRepositoryTest to get the Mongo Test Database.
     * This is in-memory and can be static to support multiple operations. */
    final static BlogRepositoryTest repo = new BlogRepositoryTest();

    @When("^An admin writes a blog with (.*) and (.*)$")
    public void anAdminWritesABlogWithBlog_titleAndBlog_content(String blogTitle, String blogContent) throws Throwable {
        log.info(String.format("...when ==> blogTitle: '%s', blogContent: '%s'", blogTitle, blogContent));

        BlogModel blog = new BlogModel();

        // Set blog date to now.
        blog.setCreatedDate(new Date());

        // Set title and content from variables
        blog.setSubject(blogTitle);
        blog.setBody(blogContent);

        // put empty info for featured img
        blog.setFeaturedImg("");

        // Save
        repo.saveBlogEntry(blog);
    }

    @Then("^application should have (\\d+) blogs with (.*)$")
    public void applicationShouldHavePlus_oneBlogsWithBlog_preview(int plusOne, String blogPreview) throws Throwable {
        log.info(String.format("...then ==> plusOne: '%d', blogPreview: '%s'", plusOne, blogPreview));

        List<BlogModel> blogs = repo.getAllBlogs();

        // test counts match
        assert blogs.size() == plusOne;

        // this will come in sorted with most recent on top
        BlogModel blog = blogs.get(0);

        // test preview content matches
        assert blog.getBodyPreview().equals(blogPreview);

    }
}
