package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ResourceBundle;

@Controller
public class IndexController {
 
    @RequestMapping("/index")
    public String hello(Model model) {

        ResourceBundle resources = ResourceBundle.getBundle("Messages");
        // header
        model.addAttribute("brand", resources.getString("index.brand"));
        model.addAttribute("motto", resources.getString("index.motto"));
        //nav
        model.addAttribute("first_nav_title", resources.getString("index.first_nav_title"));
        model.addAttribute("second_nav_title", resources.getString("index.second_nav_title"));
        // index
        model.addAttribute("first_title", resources.getString("index.first_title"));
        model.addAttribute("first_body", resources.getString("index.first_body"));
        model.addAttribute("second_title", resources.getString("index.second_title"));
        model.addAttribute("second_body", resources.getString("index.second_body"));
        //
        // TODO: Do these go in a different Controller? Maybe emailDeletedController?
        // TODO: If so, please move them there and delete this TODO.
        //
        // emailDeleted
//        model.addAttribute("first_title", resources.getString("emailDeleted.first_title"));
//        model.addAttribute("first_body", resources.getString("emailDeleted.first_body"));
//        model.addAttribute("second_title", resources.getString("emailDeleted.second_title"));
//        model.addAttribute("second_body", resources.getString("emailDeleted.second_body"));
        //
        // TODO: Likewise do these go in a different Controller? Maybe emailController?
        // TODO: If so, please move them there and delete this TODO.
        //
        // email
        model.addAttribute("submit_label", resources.getString("email.submit.label"));
        model.addAttribute("success_message", resources.getString("email.subscribe.success_message"));
        model.addAttribute("fail_message", resources.getString("email.subscribe.fail_message"));
        
        return "index";

    }
 
}
	


