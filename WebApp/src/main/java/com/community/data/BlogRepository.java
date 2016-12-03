package com.community.data;

import com.community.model.BlogModel;
import com.community.model.EmailAddressModel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * This repository class provides access to Blog entries.
 */
@Component
public class BlogRepository extends BaseRepository {

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
