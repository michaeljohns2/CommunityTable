package com.community.controller;

import com.community.data.EmailRepository;
import com.community.model.EmailAddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.UnknownHostException;

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

        EmailAddressModel emailAddressModel = new EmailAddressModel();
        model.addAttribute("emailAddressModel", emailAddressModel);

        return "email";
    }

    @RequestMapping(value="/email", method=RequestMethod.POST)
    public String processEvent(EmailAddressModel emailAddressModel, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("emailAddressModel", emailAddressModel);
            return "email";
        }

        // Save the email
        try {
            if (emailRepo.getEmail(emailAddressModel.getEmailAddress()) != null) {

                // TODO email exists.
                return "email";
            }
            emailRepo.saveEmail(emailAddressModel);
        } catch (UnknownHostException ex) {
            // TODO display some sort of error message.
            return "email";
        }


        // TODO display some kind of success message

        return "redirect:index.html";
    }
}
