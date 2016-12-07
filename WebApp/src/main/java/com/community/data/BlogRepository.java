package com.community.data;

import com.community.Exceptions.EmailNotFoundException;
import com.community.model.BlogModel;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

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

        // Attempt to get blog content as string from BSON binary data.
        Object bodyObject = blogDoc.get(BLOG_BODY);
        String body = "Unable to retrieve blog content.";
        if (bodyObject instanceof BsonBinary) {
            BsonBinary bsonBody = (BsonBinary)bodyObject;
            body = new String(bsonBody.getData());
        }
        blogModel.setBody(body);

        // Attempt to get created date.
        Object createdDateObject = blogDoc.get(BLOG_CREATED_DATE);
        BsonDateTime createdDate = null;
        if (createdDateObject instanceof BsonDateTime) {
            createdDate = (BsonDateTime)createdDateObject;
            if (createdDate != null) {
                blogModel.setCreatedDate(new Date(createdDate.getValue()));
            }
        }

        BsonObjectId id = (BsonObjectId)blogDoc.get("_id");
        if (id != null) {
            blogModel.setBlogId(id.getValue().toString());
        }

        return blogModel;
    }

    public BlogModel getBlog(String id) {
        if ((id == null) | id.equals("")) {return null;}
        MongoDatabase db = this.getMongoDatabase();
        MongoCollection<BsonDocument> blogCollection = db.getCollection(BLOG_COLLECTION, BsonDocument.class);

        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));

        FindIterable<BsonDocument> results = blogCollection.find(query);
        BsonDocument result = results.first();
        if (result==null) {
            return null;
        } else {
            try {
                BlogModel blog = mapBlog(result);
                return blog;
            }
            catch (Exception e) {
                return null;
            }
        }
    }

    public List<BlogModel> getAllBlogs() {
        final List<BlogModel> blogs = new ArrayList<BlogModel>();
        MongoDatabase db = this.getMongoDatabase();
        MongoCollection<BsonDocument> blogCollection = db.getCollection(BLOG_COLLECTION, BsonDocument.class);

        FindIterable<BsonDocument> results = blogCollection.find();

        for (BsonDocument result : results) {
            blogs.add(mapBlog(result));
        }

        Collections.sort(blogs);

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


    public void deleteBlog(String blogId) throws EmailNotFoundException {

        MongoDatabase db = this.getMongoDatabase();
        MongoCollection<Document> blogCollection = db.getCollection(BLOG_COLLECTION);

        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(blogId));

        long resultCount = blogCollection.count(query);

        if (resultCount > 0) {
            blogCollection.deleteOne(query);
        }
    }
}
