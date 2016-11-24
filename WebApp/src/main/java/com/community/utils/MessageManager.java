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

    /**
     * Replace params within a message, if present.
     * Follows pattern where placeholder '{$pair._1}' is replaced with value from pair._2
     * @param token String key for message resource
     * @param pairs StrPair vararg to replace, if present
     * @return String message with replacement
     */
    public String getMessageWithReplacements(String token, StrPair...pairs){
        return messageReplacement(getMessage(token),pairs);
    }

    /**
     * Separated for unit testing.
     *
     * @param msg String message in which to replace params, if present.
     * @param pairs StrPair vararg to replace, if present
     * @return String message with replacements
     */
    protected String messageReplacement(final String msg, StrPair... pairs){
        String _msg = msg;
        for (StrPair pair : pairs)
            _msg = _msg.replace(String.format("{$%s}",pair._1),pair._2);
        return _msg;
    }

    public ResourceBundle getMessages() {
        return messages;
    }
}
