package com.community.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a blog entry.
 */
public class BlogModel implements Comparable<BlogModel> {

    private String subject;
    private String body;
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

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        return format.format(this.createdDate);
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