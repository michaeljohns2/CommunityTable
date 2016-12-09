package com.community.model.service;

import com.community.Exceptions.EmailSendException;
import com.community.model.EmailModel;
import com.community.utils.ConfigManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for sending emails.
 */
@Service
public class JavaMailEmailSender implements IEmailSender {

    private String emailHost = "";
    private String emailUser = "";

    public JavaMailEmailSender() {
        emailHost = ConfigManager.getInstance().getSetting(ConfigManager.SMTP_HOST_KEY);
        emailUser = ConfigManager.getInstance().getSetting(ConfigManager.SMTP_USER_KEY);
    }

    /**
     * This flavor of the EmailSender uses JavaMail.
     *
     * @param email
     * @param fromAddress
     */
    public void sendEmail(EmailModel email, String fromAddress) throws EmailSendException {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", ConfigManager.getInstance().getSetting(ConfigManager.SMTP_START_TTLS_KEY));
        properties.put("mail.smtp.host", ConfigManager.getInstance().getSetting(ConfigManager.SMTP_HOST_KEY));
        properties.put("mail.smtp.port", ConfigManager.getInstance().getSetting(ConfigManager.SMTP_PORT_KEY));

        //Address 'PKIX path building failed ... unable to find valid certification path to requested target'
        properties.put("mail.smtp.ssl.trust","*");//use naive

        Session session = Session.getDefaultInstance(properties,
        new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        ConfigManager.getInstance().getSetting(ConfigManager.SMTP_USER_KEY),
                        ConfigManager.getInstance().getSetting(ConfigManager.SMTP_USER_PASSWORD_KEY));
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getSendTo().getEmailAddress()));
            message.setSubject(email.getSubject());
            message.setContent(email.getEmailContent(), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.print(e.toString());
            throw new EmailSendException(e.toString());
        }
    }

}


