package com.community.data;

import com.community.model.BlogModel;
import com.community.model.EmailAddressModel;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This repository class provides access to Blog entries.
 */
@Component
public class BlogRepository extends BaseRepository {

    private BlogModel mapBlog(BsonDocument blogDoc) {
        if ((blogDoc.get(BLOG_SUBJECT) == null) ||
                (blogDoc.get(BLOG_BODY) == null) ||
                (blogDoc.get(BLOG_CREATED_DATE) == null)) {
            throw new RuntimeException("Stored blog object is invalid.");
        }

        BlogModel blogModel = new BlogModel();

        BsonString subject = (BsonString)blogDoc.get(BLOG_SUBJECT);
        blogModel.setSubject(subject.getValue().toString());

        BsonBinary bsonBody = (BsonBinary)blogDoc.get(BLOG_BODY);
        String body = new String(bsonBody.getData());
        blogModel.setBody(body);

        BsonDateTime createdDate = (BsonDateTime)blogDoc.get(BLOG_CREATED_DATE);
        blogModel.setCreatedDate(new Date(createdDate.getValue()));

        BsonObjectId id = (BsonObjectId)blogDoc.get("_id");
        if (id != null) {
            blogModel.setBlogId(id.getValue().toString());
        }

        return blogModel;
    }


    public List<BlogModel> getAllBlogs() {
        final List<BlogModel> blogs = new ArrayList<BlogModel>();
        MongoDatabase db = this.getMongoDatabase();
        MongoCollection<BsonDocument> blogCollection = db.getCollection(BLOG_COLLECTION, BsonDocument.class);

        FindIterable<BsonDocument> results = blogCollection.find();
        for (BsonDocument result : results) {
            blogs.add(mapBlog(result));
        }

        return blogs;
    }

    /**
     * Attempts to save a BlogModel as a MongoDB blog entry.
     *
     * @throws UnknownHostException
     */
    public void saveBlogEntry(BlogModel blogModel) throws UnknownHostException {
        if (blogModel == null || blogModel.getBody() == null) {
            throw new IllegalArgumentException("Blog cannot be null.");
        }

        MongoDatabase db = this.getMongoDatabase();

        //Note: using BsonDocument given the nature of the contents.
        MongoCollection<BsonDocument> blogCollection = db.getCollection(BLOG_COLLECTION, BsonDocument.class);

        BsonDocument bDoc = new BsonDocument();
        bDoc.put(BLOG_SUBJECT, new BsonString(blogModel.getSubject()));//String
        bDoc.put(BLOG_BODY, new BsonBinary(blogModel.getBody().getBytes()));//byte[]
        bDoc.put(BLOG_CREATED_DATE, new BsonDateTime(blogModel.getCreatedDate().getTime()));//long

        blogCollection.insertOne(bDoc);
    }
}
