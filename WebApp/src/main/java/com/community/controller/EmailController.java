package com.community.controller;

import com.community.Exceptions.EmailNotFoundException;
import com.community.data.EmailRepository;
import com.community.model.EmailAddressModel;
import com.community.utils.MessageManager;
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
 * This is controller for handling email functions.
 * Unsubscribe is handled via this controller.
 * Subscribe is handled via the {@link com.community.controller.rest.EmailRestController}.
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

    @RequestMapping(value="/email/unsubscribe", method=RequestMethod.GET)
    public String deleteEmail(@RequestParam(name="key") String secureHash, Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header
        model.addAttribute("brand", mgr.getMessage("index.brand"));
        model.addAttribute("motto", mgr.getMessage("index.motto"));

        //nav
        model.addAttribute("first_nav_title", mgr.getMessage("index.first_nav_title"));
        model.addAttribute("second_nav_title", mgr.getMessage("index.second_nav_title"));

        // emailDeleted
        model.addAttribute("first_title", mgr.getMessage("emailDeleted.first_title"));
        model.addAttribute("first_body", mgr.getMessage("emailDeleted.first_body"));

        // emailDeleteFail
        model.addAttribute("fail", mgr.getMessage("emailDeleteFailed.message"));

        try {
            emailRepo.deleteEmail(secureHash);
            return "emailDeleted";//emailDeleted.jsp
        } catch (EmailNotFoundException e) {
            return "emailDeleteFailed";//emailDeleteFailed.jsp
        }
    }
}
