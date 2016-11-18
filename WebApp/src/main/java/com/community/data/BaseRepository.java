package com.community.data;

import com.community.utils.ConfigManager;
import com.mongodb.MongoClient;
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

    public BaseRepository() {
        mongoServerName = ConfigManager.getInstance().getSetting(ConfigManager.MONGO_SERVER_KEY);
        mongoDbName = ConfigManager.getInstance().getSetting(ConfigManager.DB_NAME_KEY);
        mongoDbPort = ConfigManager.getInstance().getSettingAsInt(ConfigManager.DB_PORT_KEY);
    }

    public MongoDatabase getMongoDatabase() {
        MongoClient mongo = new MongoClient(mongoServerName,mongoDbPort);
        return mongo.getDatabase(mongoDbName);
    }
}
