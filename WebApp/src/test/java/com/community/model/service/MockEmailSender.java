package com.community.model.service;

import com.community.Exceptions.EmailSendException;
import com.community.model.EmailModel;

/**
 * This is a Mock email sender that can be used by unit tests
 */
public class MockEmailSender implements IEmailSender {

    public static final String MOCK_SEND_FAIL_TRIGGER_EMAIL = "fail@fail.com";

    public void sendEmail(EmailModel email, String fromAddress) throws EmailSendException {

        if (email.getSendTo().getEmailAddress().equals(MOCK_SEND_FAIL_TRIGGER_EMAIL)) {
            throw new EmailSendException("Mock exception on send.");
        }
        // Do nothing, let calling tests pass.
    }

}
