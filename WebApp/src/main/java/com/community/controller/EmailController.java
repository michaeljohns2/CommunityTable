package com.community.controller;

import com.community.data.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.community.model.EmailModel;

import java.net.UnknownHostException;
import java.util.ResourceBundle;

/**
 * This is a sample controller for handling email functions.
 * It shows how data can be posted.
 */
@Controller
public class EmailController {

    @Autowired
    EmailRepository emailRepo;

    @RequestMapping(value="/email", method= RequestMethod.GET)
    public String displayEmailSignup(Model model) {

        ResourceBundle resources = ResourceBundle.getBundle("Messages");
        model.addAttribute("reglbl", resources.getString("enter.email.registration.label"));

        EmailModel emailModel = new EmailModel();
        model.addAttribute("emailModel", emailModel);

        return "email";
    }

    @RequestMapping(value="/email", method=RequestMethod.POST)
    public String processEmail(EmailModel emailModel, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("emailModel", emailModel);
            return "email";
        }

        // Save the email
        try {
            if (emailRepo.getEmail(emailModel.getEmailAddress()) != null) {
                // TODO email exists.
                return "email";
            }
            emailRepo.saveEmail(emailModel);
        } catch (UnknownHostException ex) {
            // TODO display some sort of error message.
            return "email";
        }


        // TODO display some kind of success message

        return "redirect:index.html";
    }
}
