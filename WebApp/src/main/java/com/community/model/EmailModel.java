package com.community.model;

/**
 * This class represents an instance of an email that the system will send.
 */
public class EmailModel {

    private String emailContent;
    private EmailAddressModel sendTo;
    private String subject;

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public EmailAddressModel getSendTo() {
        return sendTo;
    }

    public void setSendTo(EmailAddressModel sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
