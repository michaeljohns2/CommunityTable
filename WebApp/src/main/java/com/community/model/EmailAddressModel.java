package com.community.model;


import java.util.UUID;

/**
 *      This model represents the data associated with an email account.
 */
public class EmailAddressModel {

    private String emailAddress;
    private String secureHash;

    public EmailAddressModel() {
        setSecureHash(UUID.randomUUID().toString());
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public String getSecureHash() {
        return secureHash;
    }

    /**
     * A unique value used to secure the unsubscribe function.
     *
     * @param secureHash
     */
    public void setSecureHash(String secureHash) {
        this.secureHash = secureHash;
    }
}