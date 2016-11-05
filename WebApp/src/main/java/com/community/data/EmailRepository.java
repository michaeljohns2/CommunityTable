package com.community.data;

import com.community.model.EmailModel;
import com.google.common.collect.Iterables;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * Created by keljd on 11/3/2016.
 */
@Component
public class EmailRepository extends BaseRepository {

    private static final String EMAIL_COLLECTION = "emailCollection";
    private static final String EMAIL_FIELD = "emailAddress";




    /**
     * Attempts to save an EmailModel as a MongoDB email entry.
     *
     * @param emailModel
     * @throws UnknownHostException
     */
    public void saveEmail(EmailModel emailModel) throws UnknownHostException {
        if (emailModel == null || emailModel.getEmailAddress() == null) {
            throw new IllegalArgumentException("EmailAddress cannot be null.");
        }

        MongoDatabase db = this.getMongoDatabase();

        Document emailDoc = new Document();
        emailDoc.put(EMAIL_FIELD, emailModel.getEmailAddress());

        MongoCollection<Document> emailCollection = db.getCollection(EMAIL_COLLECTION);
        emailCollection.insertOne(emailDoc);

    }

    /**
     * Attempts to find and return an emailModel by email addres.
     *
     * @return  A found emailModel matching the email address, or null.
     * @throws UnknownHostException
     */
    public EmailModel getEmail(String emailAddress) throws UnknownHostException {


        MongoDatabase db = this.getMongoDatabase();
        MongoCollection<Document> emailCollection = db.getCollection(EMAIL_COLLECTION);

        FindIterable<Document> results = emailCollection.find(eq("emailAddress", emailAddress));

        if (Iterables.size(results) < 1) {
            return null;
        }
        Document email = results.first();

        if (email.get(EMAIL_FIELD) == null) {
            throw new RuntimeException("Stored email object is invalid.");
        }

        EmailModel foundEmail = new EmailModel();
        foundEmail.setEmailAddress(email.get(EMAIL_FIELD).toString());
        return foundEmail;
    }
}
