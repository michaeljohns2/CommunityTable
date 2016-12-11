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

    private BlogModel mapBlog(BsonDocument blogDoc, boolean featuredImgOnly) {

        // Initiate model.
        BlogModel blogModel = new BlogModel();

        // skip this if only asking for featuredImg (speed up GET request)
        if (!featuredImgOnly) {

            //Some of these are large objects, so just getting them 1x.
            BsonString subject = null;
            Object bodyObject = null;
            Object createdDateObject = null;

            try {
                subject = (BsonString) blogDoc.get(BLOG_SUBJECT);
                bodyObject = blogDoc.get(BLOG_BODY);
                createdDateObject = blogDoc.get(BLOG_CREATED_DATE);
                if (
                        subject == null ||
                                bodyObject == null ||
                                createdDateObject == null) {
                    throw new RuntimeException("Stored blog object is invalid.");
                }
            } catch (Exception e) {
                throw new RuntimeException("Stored blog object is invalid.");
            }

            // Set blog subject and id.
            blogModel.setSubject(subject.getValue().toString());
            BsonObjectId id = (BsonObjectId) blogDoc.get("_id");
            if (id != null) {
                blogModel.setBlogId(id.getValue().toString());
            }

            // Attempt to get blog content as string from BSON binary data.
            String body = "Unable to retrieve blog content.";
            if (bodyObject instanceof BsonBinary) {
                BsonBinary bson = (BsonBinary) bodyObject;
                body = new String(bson.getData());
            }
            blogModel.setBody(body);

            // Attempt to get created date.
            BsonDateTime createdDate = null;
            if (createdDateObject instanceof BsonDateTime) {
                createdDate = (BsonDateTime) createdDateObject;
                if (createdDate != null) {
                    blogModel.setCreatedDate(new Date(createdDate.getValue()));
                }
            }
        }

        //Attempt to get featured img
        String img = "";
        Object featuredImgObject = null;
        try {
            featuredImgObject = blogDoc.get(BLOG_FEATURED_IMG);
        } catch(Exception ignore){}
        if (featuredImgObject != null && featuredImgObject instanceof BsonBinary) {
            BsonBinary bson = (BsonBinary)featuredImgObject;
            img = new String(bson.getData());
        }
        blogModel.setFeaturedImg(img);

        return blogModel;
    }

    public BlogModel getBlog(String id){
        return getBlog(id, false);
    }

    public BlogModel getBlog(String id, boolean featuredImgOnly) {
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
                BlogModel blog = mapBlog(result,featuredImgOnly);
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
            blogs.add(mapBlog(result,false));
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
        bDoc.put(BLOG_FEATURED_IMG, new BsonBinary(blogModel.getFeaturedImg().getBytes()));//byte[]
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
