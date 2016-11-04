package com.community.data;

import com.community.model.EmailModel;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * Created by keljd on 11/3/2016.
 */
@Component
public class EmailRepository {

    private static final String EMAIL_COLLECTION = "emailCollection";
    private static final String EMAIL_FIELD = "emailAddress";
    private static final String DB_NAME = "CommunityTables";

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

        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB(DB_NAME);

        BasicDBObject emailDoc = new BasicDBObject();
        emailDoc.put(EMAIL_FIELD, emailModel.getEmailAddress());

        DBCollection table = db.getCollection(EMAIL_COLLECTION);
        table.insert(emailDoc);

    }

    /**
     * Attempts to find and return an emailModel by email addres.
     *
     * @return  A found emailModel matching the email address, or null.
     * @throws UnknownHostException
     */
    public EmailModel getEmail(String emailAddress) throws UnknownHostException {


        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB(DB_NAME);
        DBCollection emailCollection = db.getCollection(EMAIL_COLLECTION);
        BasicDBObject query = new BasicDBObject();
        query.put(EMAIL_FIELD, emailAddress);

        DBObject dbObject = emailCollection.findOne(query);
        if (dbObject == null) {
            return null;
        }

        if (dbObject.get(EMAIL_FIELD) == null) {
            throw new RuntimeException("Stored email object is invalid.");
        }

        EmailModel foundEmail = new EmailModel();
        foundEmail.setEmailAddress(dbObject.get(EMAIL_FIELD).toString());
        return foundEmail;
    }
}
