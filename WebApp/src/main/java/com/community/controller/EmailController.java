package com.community.controller;

import com.community.Exceptions.EmailNotFoundException;
import com.community.data.EmailRepository;
import com.community.model.EmailAddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

        ResourceBundle resources = ResourceBundle.getBundle("Messages");

        // Save the email
        try {
            if (emailRepo.getEmail(emailAddressModel.getEmailAddress()) != null) {

                // TODO duplicate email message (IS THIS OVERCOME BY USE OF 'EmailRestController'?)

                return "email";
            }
            emailRepo.saveEmail(emailAddressModel);
        } catch (UnknownHostException ex) {

            // TODO fail message  (IS THIS OVERCOME BY USE OF 'EmailRestController'?)

            return "email";
        }

        // TODO success message (IS THIS OVERCOME BY USE OF 'EmailRestController'?)

        return "redirect:index.html";
    }

    @RequestMapping(value="/email/unsubscribe", method=RequestMethod.GET)
    public String deleteEmail(@RequestParam(name="key") String secureHash) {
        try {
            emailRepo.deleteEmail(secureHash);
            return "emailDeleted";
        } catch (EmailNotFoundException e) {
            return "emailDeleteFailed";
        }
    }
}
