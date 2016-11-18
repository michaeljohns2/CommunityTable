package com.community.model.service;

import com.community.Exceptions.InvalidEmailException;
import com.community.Exceptions.TemplateNotFoundException;
import com.community.model.EmailAddressModel;
import com.community.model.EmailModel;
import com.community.utils.ConfigManager;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by keljd on 11/8/2016.
 */
@Service
public class EmailBuilder {

    public static final String EMAIL_TEMPLATE_WELCOME = "welcomeEmail";
    public static final String EMAIL_TEMPLATE_WRAPPER = "emailWrapper";

    private String host = "";

    public EmailBuilder() {
        host = ConfigManager.getInstance().getSetting(ConfigManager.HOST_PATH_KEY);
    }

    /**
     * This method retrieves a requested email template by name and returned the wrapped content.
     *
     * @param templateName  The name of the content template file as it exists in /resources/emailTemplates
     * @return  Sting representation of the wrapped email.
     * @throws TemplateNotFoundException
     */
    public EmailModel buildEmail(String templateName, EmailAddressModel sendTo)
            throws TemplateNotFoundException, InvalidEmailException {
        if (sendTo == null || sendTo.getEmailAddress() == null || sendTo.getSecureHash() == null) {
            throw new InvalidEmailException("Invalid Email Account Data");
        }
        String emailContent = null;

        String wrapper = getFileContents(EMAIL_TEMPLATE_WRAPPER);
        String content = getFileContents(templateName);
        emailContent = wrapper.replace("{$email.content}", content);

        // Add unsubscribe link.
        String unsubscribe = host + "email/unsubscribe.html?key=" + sendTo.getSecureHash();
        emailContent = emailContent.replace("{$email.unsubscribe.link}", unsubscribe);

        EmailModel email = new EmailModel();
        email.setEmailContent(emailContent);
        email.setSendTo(sendTo);

        return email;
    }

    private String getFileContents(String templateName) throws TemplateNotFoundException {
        String content = null;
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("emailTemplates/" + templateName + ".html");
        if (resource == null) {
            throw new TemplateNotFoundException(String.format("Did not find template [%s.html]", templateName));
        }

        try {
            File file = new File(resource.toURI());
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (Exception ex) {
            throw new TemplateNotFoundException(String.format("Did not find template [%s.html]", templateName));
        }
        return content;
    }
}
