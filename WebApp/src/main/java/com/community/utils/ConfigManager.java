package com.community.utils;

import java.util.ResourceBundle;

/**
 * This is a convenience singleton class to get server properties.
 * By default it will use values from 'Server.properties'.
 * It will use overrides from 'Server_Custom.properties' if locally provided.
 *
 * Created by mjohns on 11/17/16.
 */
public class ConfigManager {

    /* mongo */
    public static final String MONGO_SERVER_KEY = "mongo.server";
    public static final String DB_NAME_KEY = "db.name";
    public static final String DB_PORT_KEY = "db.port";
    public static final String HOST_PATH_KEY = "host.path";

    /* smtp */
    public static final String SMTP_HOST_KEY = "smtp.host";
    public static final String SMTP_USER_KEY = "smtp.user";
    public static final String SMTP_USER_PASSWORD_KEY = "smtp.user.password";

    /* auth */
    public static final String AUTH_ADMIN_USER_KEY = "auth.admin.user";
    public static final String AUTH_ADMIN_PASSWORD_KEY = "auth.admin.password";
    public static final String AUTH_ADMIN_ROLE_KEY = "auth.admin.role";

    private static ConfigManager _instance = null;

    public static ConfigManager getInstance(){
        if (_instance == null){
            _instance = new ConfigManager();
        }
        return _instance;
    }

    ResourceBundle defaultConfig = null;
    ResourceBundle customConfig = null;

    private ConfigManager() {
        defaultConfig = ResourceBundle.getBundle("Server");
        try {
            customConfig = ResourceBundle.getBundle("Server_Custom");
        } catch(Exception ignore){}
    }

    public String getSetting(String token) {

        if (customConfig != null && customConfig.containsKey(token))
            return customConfig.getString(token);

        return defaultConfig.getString(token);
    }

    public int getSettingAsInt(String token) {

        if (customConfig != null && customConfig.containsKey(token))
            return Integer.parseInt(customConfig.getString(token));

        return Integer.parseInt(defaultConfig.getString(token));
    }
}
