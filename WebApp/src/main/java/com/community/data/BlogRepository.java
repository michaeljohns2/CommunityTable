package com.community.data;

import com.community.model.BlogModel;
import com.community.model.EmailAddressModel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
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

        Document emailDoc = new Document();
        emailDoc.put(BLOG_SUBJECT, blogModel.getSubject());
        emailDoc.put(BLOG_BODY, blogModel.getBody());
        emailDoc.put(BLOG_CREATED_DATE, blogModel.getCreatedDate().toString());

        MongoCollection<Document> blogCollection = db.getCollection(BLOG_COLLECTION);
        blogCollection.insertOne(emailDoc);
    }
}
