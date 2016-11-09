package com.community.utils;

import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

/**
 * This is a convenience class used to retrieve messages.
 */
@Component
public class MessageManager {
    ResourceBundle messages;

    public MessageManager() {
        messages = ResourceBundle.getBundle("Messages");
    }

    public String getMessage(String token) {
        return messages.getString(token);
    }
}
