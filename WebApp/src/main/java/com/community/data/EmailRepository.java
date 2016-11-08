package com.community.data;

import com.community.model.EmailAddressModel;
import com.google.common.collect.Iterables;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * This repository class provides access to Email data.
 */
@Component
public class EmailRepository extends BaseRepository {

    /**
     * Attempts to save an EmailAddressModel as a MongoDB email entry.
     *
     * @param emailAddressModel
     * @throws UnknownHostException
     */
    public void saveEmail(EmailAddressModel emailAddressModel) throws UnknownHostException {
        if (emailAddressModel == null || emailAddressModel.getEmailAddress() == null) {
            throw new IllegalArgumentException("EmailAddress cannot be null.");
        }

        MongoDatabase db = this.getMongoDatabase();

        Document emailDoc = new Document();
        emailDoc.put(EMAIL_FIELD, emailAddressModel.getEmailAddress());

        MongoCollection<Document> emailCollection = db.getCollection(EMAIL_COLLECTION);
        emailCollection.insertOne(emailDoc);

    }

    /**
     * Attempts to find and return an emailModel by email addres.
     *
     * @return  A found emailModel matching the email address, or null.
     * @throws UnknownHostException
     */
    public EmailAddressModel getEmail(String emailAddress) throws UnknownHostException {

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

        EmailAddressModel foundEmail = new EmailAddressModel();
        foundEmail.setEmailAddress(email.get(EMAIL_FIELD).toString());
        return foundEmail;
    }

    public List<EmailAddressModel> getAllEmails() {
        final List<EmailAddressModel> emails = new ArrayList<EmailAddressModel>();
        MongoDatabase db = this.getMongoDatabase();
        MongoCollection<Document> emailCollection = db.getCollection(EMAIL_COLLECTION);

        FindIterable<Document> results = emailCollection.find();
        for (Document result : results) {
            emails.add(mapEmail(result));
        }

        return emails;
    }

    private EmailAddressModel mapEmail(Document emailDoc) {
        if (emailDoc.get(EMAIL_FIELD) == null) {
            throw new RuntimeException("Stored email object is invalid.");
        }

        EmailAddressModel emailAddressModel = new EmailAddressModel();
        emailAddressModel.setEmailAddress(emailDoc.get(EMAIL_FIELD).toString());
        return emailAddressModel;
    }
}
