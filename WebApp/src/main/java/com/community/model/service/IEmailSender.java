package com.community.model.service;

import com.community.Exceptions.EmailSendException;
import com.community.model.EmailModel;

/**
 * Created by keljd on 11/14/2016.
 */
public interface IEmailSender {

    void sendEmail(EmailModel email, String fromAddress) throws EmailSendException;

}
