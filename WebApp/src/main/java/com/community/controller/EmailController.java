package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.community.model.EmailModel;

/**
 * This is a sample controller for handling email functions.
 * It shows how data can be posted.
 */
@Controller
public class EmailController {

    @RequestMapping(value="/email", method= RequestMethod.GET)
    public String displayEmailSignup(Model model) {

        EmailModel emailModel = new EmailModel();
        model.addAttribute("emailModel", emailModel);

        return "email";
    }

    @RequestMapping(value="/email", method=RequestMethod.POST)
    public String processEvent(EmailModel emailModel, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("emailModel", emailModel);
            return "email";
        }
        return "redirect:index.html";
    }
}
