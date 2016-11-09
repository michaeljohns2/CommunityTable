package com.community.model.service;

import com.community.model.EmailModel;
import org.springframework.stereotype.Service;

import java.util.ResourceBundle;

/**
 * This class is responsible for sending emails.
 */
@Service
public class EmailSender {

    private String emailHost = "";

    public EmailSender() {
        ResourceBundle resources = ResourceBundle.getBundle("Server");
        emailHost = resources.getString("smtp.host");
    }

    /**
     * This method is a STUB. Waiting for SMTP to populate.
     *
     * @param email
     * @param fromAddress
     */
    public void sendEmail(EmailModel email, String fromAddress) {

        // TODO actually send email.
        System.out.print("Email subject:" + email.getSubject());
        System.out.print(email.getEmailContent());
    }
}
