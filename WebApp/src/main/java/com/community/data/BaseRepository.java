package com.community.data;

import com.community.utils.ConfigManager;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.util.ResourceBundle;

/**
 * Created by keljd on 11/5/2016.
 */
public class BaseRepository implements DataConstants {

    //protected for tests
    protected String mongoServerName = null;
    protected String mongoDbName = null;
    protected int mongoDbPort = 0;
    protected String mongoDbUser = null;
    protected String mongoDbPassword = null;

    public BaseRepository() {
        mongoServerName = ConfigManager.getInstance().getSetting(ConfigManager.MONGO_SERVER_KEY);
        mongoDbName = ConfigManager.getInstance().getSetting(ConfigManager.DB_NAME_KEY);
        mongoDbPort = ConfigManager.getInstance().getSettingAsInt(ConfigManager.DB_PORT_KEY);
        mongoDbUser = ConfigManager.getInstance().getSetting(ConfigManager.DB_USER);
        mongoDbPassword = ConfigManager.getInstance().getSetting(ConfigManager.DB_PASSWORD);
    }

    public MongoDatabase getMongoDatabase() {
        MongoClient mongo = null;
        if (mongoDbUser.trim().equals("")) {
            mongo = new MongoClient(mongoServerName, mongoDbPort);
        } else {
            MongoClientURI uri = new MongoClientURI(
                    String.format("mongodb://%s:%s@%s:%s/%s",
                            mongoDbUser,
                            mongoDbPassword,
                            mongoServerName,
                            mongoDbPort,
                            mongoDbName
                            ));
            mongo = new MongoClient(uri);
        }

        MongoDatabase db =  mongo.getDatabase(mongoDbName);
        return db;
    }
}
