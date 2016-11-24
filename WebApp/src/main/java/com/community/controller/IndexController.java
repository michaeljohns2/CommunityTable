package com.community.controller;

import com.community.utils.MessageManager;
import com.community.utils.StrPair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ResourceBundle;

@Controller
public class IndexController {
 
    @RequestMapping("/index")
    public String hello(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header
        model.addAttribute("title", mgr.getMessage("index.title"));
        model.addAttribute("brand", mgr.getMessage("brand"));

        // nav
        model.addAttribute("nav_title_1", mgr.getMessage("nav_title_1"));
        model.addAttribute("nav_title_2", mgr.getMessage("nav_title_2"));
        model.addAttribute("nav_title_3", mgr.getMessage("nav_title_3"));

        // index
        model.addAttribute("first_title", mgr.getMessage("index.first_title"));
        model.addAttribute("first_body", mgr.getMessage("index.first_body"));
        model.addAttribute("second_title", mgr.getMessage("index.second_title"));
        model.addAttribute("second_body", mgr.getMessage("index.second_body"));

        // email
        model.addAttribute("submit_label", mgr.getMessage("email.submit.label"));
        model.addAttribute("success_message", mgr.getMessage("email.subscribe.success_message"));
        model.addAttribute("fail_message", mgr.getMessage("email.subscribe.fail_message"));
        
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header
        model.addAttribute("title", mgr.getMessage("about.title"));
        model.addAttribute("brand", mgr.getMessage("brand"));

        // nav
        model.addAttribute("nav_title_1", mgr.getMessage("nav_title_1"));
        model.addAttribute("nav_title_2", mgr.getMessage("nav_title_2"));
        model.addAttribute("nav_title_3", mgr.getMessage("nav_title_3"));
        model.addAttribute("username_label", mgr.getMessage("username_label"));
        model.addAttribute("password_label", mgr.getMessage("password_label"));
        model.addAttribute("username_input_text", mgr.getMessage("username_input_text"));
        model.addAttribute("password_input_text", mgr.getMessage("password_input_text"));
        model.addAttribute("login_error", mgr.getMessage("login_error"));
        model.addAttribute("logout_success", mgr.getMessage("logout_success"));
        model.addAttribute("login_button", mgr.getMessage("login_button"));

        // Load login.jsp
        return "login";
    }

    @RequestMapping("/about")
    public String about(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header
        model.addAttribute("title", mgr.getMessage("about.title"));
        model.addAttribute("brand", mgr.getMessage("brand"));

        // nav
        model.addAttribute("nav_title_1", mgr.getMessage("nav_title_1"));
        model.addAttribute("nav_title_2", mgr.getMessage("nav_title_2"));
        model.addAttribute("nav_title_3", mgr.getMessage("nav_title_3"));

        // about (with a little extra to do email replacement here)
        StrPair emailPair = StrPair.of("site.email", mgr.getMessage("site.email"));

        model.addAttribute("title_1", mgr.getMessage("about.title_1"));
        model.addAttribute("body_1", mgr.getMessageWithReplacements("about.body_1", emailPair));
        model.addAttribute("title_2", mgr.getMessage("about.title_2"));
        model.addAttribute("body_2", mgr.getMessageWithReplacements("about.body_2", emailPair));
        model.addAttribute("title_3", mgr.getMessage("about.title_3"));
        model.addAttribute("body_3", mgr.getMessageWithReplacements("about.body_3",emailPair));
        model.addAttribute("title_4", mgr.getMessage("about.title_4"));
        model.addAttribute("body_4", mgr.getMessageWithReplacements("about.body_4", emailPair));

        // Load about.jsp
        return "about";
    }

    @RequestMapping("/vision")
    public String vision(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header
        model.addAttribute("brand", mgr.getMessage("brand"));

        // nav
        model.addAttribute("nav_title_1", mgr.getMessage("nav_title_1"));
        model.addAttribute("nav_title_2", mgr.getMessage("nav_title_2"));
        model.addAttribute("nav_title_3", mgr.getMessage("nav_title_3"));

        // vision
        model.addAttribute("title_1", mgr.getMessage("vision.title_1"));
        model.addAttribute("body_1", mgr.getMessage("vision.body_1"));
        model.addAttribute("title_2", mgr.getMessage("vision.title_2"));
        model.addAttribute("body_2", mgr.getMessage("vision.body_2"));
        model.addAttribute("title_3", mgr.getMessage("vision.title_3"));
        model.addAttribute("body_3", mgr.getMessage("vision.body_3"));
        model.addAttribute("title_4", mgr.getMessage("vision.title_4"));
        model.addAttribute("body_4", mgr.getMessage("vision.body_4"));
        model.addAttribute("title_5", mgr.getMessage("vision.title_5"));
        model.addAttribute("body_5", mgr.getMessage("vision.body_5"));
        model.addAttribute("title_6", mgr.getMessage("vision.title_6"));
        model.addAttribute("body_6", mgr.getMessage("vision.body_6"));
        model.addAttribute("title_7", mgr.getMessage("vision.title_7"));
        model.addAttribute("body_7", mgr.getMessage("vision.body_7"));

        // Load vision.jsp
        return "vision";
    }

}
	


