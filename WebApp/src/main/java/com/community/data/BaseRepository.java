package com.community.data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ResourceBundle;

/**
 * Created by keljd on 11/5/2016.
 */
public class BaseRepository {

    private static final String DB_NAME = "CommunityTables";

    private String mongoServerName = null;

    public BaseRepository() {
        ResourceBundle resources = ResourceBundle.getBundle("Messages");
        mongoServerName = resources.getString("mongo.server");
    }

    public MongoDatabase getMongoDatabase() {
        MongoClient mongo = new MongoClient( mongoServerName , 27017 );
        MongoDatabase db = mongo.getDatabase(DB_NAME);
        return db;
    }
}
