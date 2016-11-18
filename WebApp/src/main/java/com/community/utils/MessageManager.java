package com.community.utils;

import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

/**
 * This is a convenience singleton class used to retrieve messages.
 */
@Component
public class MessageManager {

    ResourceBundle messages;

    private static MessageManager _instance = null;

    public static MessageManager getInstance(){
        if (_instance == null){
            _instance = new MessageManager();
        }
        return _instance;
    }

    private MessageManager() {
        messages = ResourceBundle.getBundle("Messages");
    }

    public String getMessage(String token) {
        return messages.getString(token);
    }

    public ResourceBundle getMessages() {
        return messages;
    }
}
