package com.community.model;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a blog entry.
 */
public class BlogModel implements Comparable<BlogModel> {

    final private static Logger log = LoggerFactory.getLogger(BlogModel.class);

    private static final int MAX_PREVIEW_LENGTH = 300;

    private String subject;
    private String body;
    private String featuredImg;
    private Date createdDate;
    private String blogId;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFeaturedImg() {
        return featuredImg;
    }

    /**
     * This is a derived method. It IS used within BlogDetail.jsp.
     * @return
     */
    public String getFeaturedImgRelativeUrl(){
        return "blog/"+getBlogId()+"/featured-img.html";
    }

    public void setFeaturedImg(String featuredImg) {
        this.featuredImg = featuredImg;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    // A virtual property used to control display formatting.
    public String getCreatedDateForDisplay() {
        if (this.createdDate == null) {
            return "missing created date";
        }

        SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy HH:mm");
        return format.format(this.createdDate);
    }

    public String getBodyPreview()
    {
        String preview = "No preview available...";

        // Replace HTML nbsp first to avoid extra spaces.
        try {
            preview = Jsoup.parse(body.replace("&nbsp;", " "), "ISO-8859-1").text();
            if (preview.length() > MAX_PREVIEW_LENGTH) {
                return preview.substring(0, MAX_PREVIEW_LENGTH)+"...";
            }
        } catch(Exception e){
            log.error("... blog preview could not be parsed.",e);
        }

        return preview;
    }

    @Override
    public int compareTo(BlogModel compareBlogModel) {
        if (compareBlogModel.getCreatedDate() == null) {
            return 0;
        }

        //descending order
        return compareBlogModel.getCreatedDate().compareTo(this.getCreatedDate());
    }
}