package com.community.model.service;

import com.community.Exceptions.EmailSendException;
import com.community.model.EmailModel;

/**
 * This is a Mock email sender that can be used by unit tests
 */
public class MockEmailSender implements IEmailSender {

    public void sendEmail(EmailModel email, String fromAddress) throws EmailSendException {
        // Do nothing, let calling tests pass.
    }

}
