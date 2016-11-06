package com.community.data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ResourceBundle;

/**
 * Created by keljd on 11/5/2016.
 */
public class BaseRepository implements DataConstants {

    protected String mongoServerName = null;//protected for tests

    public BaseRepository() {
        ResourceBundle resources = ResourceBundle.getBundle("Messages");
        mongoServerName = resources.getString("mongo.server");
    }

    public MongoDatabase getMongoDatabase() {
        MongoClient mongo = new MongoClient(mongoServerName , DB_PORT);
        return mongo.getDatabase(DB_NAME);
    }
}
