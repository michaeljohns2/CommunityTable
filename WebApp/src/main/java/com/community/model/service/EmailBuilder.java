package com.community.model.service;

import com.community.Exceptions.TemplateNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by keljd on 11/8/2016.
 */
@Service
public class EmailBuilder {


    public static final String EMAIL_TEMPLATE_WELCOME = "welcomeEmail";

    /**
     * This method retrieves a requested email template by name and returned the wrapped content.
     *
     * @param templateName  The name of the content template file as it exists in /resources/emailTemplates
     * @return  Sting representation of the wrapped email.
     * @throws TemplateNotFoundException
     */
    public String buildEmail(String templateName) throws TemplateNotFoundException{
        String emailContent = null;

        String wrapper = getFileContents("emailWrapper");
        String content = getFileContents(templateName);
        emailContent = wrapper.replace("{$email.content}", content);

        return emailContent;
    }

    private String getFileContents(String templateName) throws TemplateNotFoundException {
        String content = null;
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("emailTemplates/" + templateName + ".html");
        if (resource == null) {
            throw new TemplateNotFoundException(String.format("Did not find template [%s.html]", templateName));
        }
        File file = new File(resource.getFile());

        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex) {
            throw new TemplateNotFoundException(String.format("Did not find template [%s.html]", templateName));
        }
        return content;
    }
}
