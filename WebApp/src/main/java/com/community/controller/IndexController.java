package com.community.controller;

import com.community.utils.MessageManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ResourceBundle;

@Controller
public class IndexController {
 
    @RequestMapping("/index")
    public String hello(Model model) {

        ResourceBundle resources = MessageManager.getInstance().getMessages();

        // header
        model.addAttribute("title", resources.getString("index.title"));
        model.addAttribute("brand", resources.getString("brand"));

        // nav
        model.addAttribute("nav_title_1", resources.getString("nav_title_1"));
        model.addAttribute("nav_title_2", resources.getString("nav_title_2"));
        model.addAttribute("nav_title_3", resources.getString("nav_title_3"));

        // index
        model.addAttribute("first_title", resources.getString("index.first_title"));
        model.addAttribute("first_body", resources.getString("index.first_body"));
        model.addAttribute("second_title", resources.getString("index.second_title"));
        model.addAttribute("second_body", resources.getString("index.second_body"));

        // email
        model.addAttribute("submit_label", resources.getString("email.submit.label"));
        model.addAttribute("success_message", resources.getString("email.subscribe.success_message"));
        model.addAttribute("fail_message", resources.getString("email.subscribe.fail_message"));
        
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        ResourceBundle resources = MessageManager.getInstance().getMessages();

        // header
        model.addAttribute("title", resources.getString("about.title"));
        model.addAttribute("brand", resources.getString("brand"));

        // nav
        model.addAttribute("nav_title_1", resources.getString("nav_title_1"));
        model.addAttribute("nav_title_2", resources.getString("nav_title_2"));
        model.addAttribute("nav_title_3", resources.getString("nav_title_3"));
        model.addAttribute("username_label", resources.getString("username_label"));
        model.addAttribute("password_label", resources.getString("password_label"));
        model.addAttribute("username_input_text", resources.getString("username_input_text"));
        model.addAttribute("password_input_text", resources.getString("password_input_text"));
        model.addAttribute("login_error", resources.getString("login_error"));
        model.addAttribute("logout_success", resources.getString("logout_success"));
        model.addAttribute("login_button", resources.getString("login_button"));

        // Load login.jsp
        return "login";
    }

    @RequestMapping("/about")
    public String about(Model model) {

        ResourceBundle resources = MessageManager.getInstance().getMessages();

        // header
        model.addAttribute("title", resources.getString("about.title"));
        model.addAttribute("brand", resources.getString("brand"));

        // nav
        model.addAttribute("nav_title_1", resources.getString("nav_title_1"));
        model.addAttribute("nav_title_2", resources.getString("nav_title_2"));
        model.addAttribute("nav_title_3", resources.getString("nav_title_3"));

        // about
        model.addAttribute("title_1", resources.getString("about.title_1"));
        model.addAttribute("body_1", resources.getString("about.body_1"));
        model.addAttribute("title_2", resources.getString("about.title_2"));
        model.addAttribute("body_2", resources.getString("about.body_2"));
        model.addAttribute("title_3", resources.getString("about.title_3"));
        model.addAttribute("body_3", resources.getString("about.body_3"));
        model.addAttribute("title_4", resources.getString("about.title_4"));
        model.addAttribute("body_4", resources.getString("about.body_4"));

        // Load about.jsp
        return "about";
    }

    @RequestMapping("/vision")
    public String vision(Model model) {

        ResourceBundle resources = MessageManager.getInstance().getMessages();

        // header
        model.addAttribute("brand", resources.getString("brand"));

        // nav
        model.addAttribute("nav_title_1", resources.getString("nav_title_1"));
        model.addAttribute("nav_title_2", resources.getString("nav_title_2"));
        model.addAttribute("nav_title_3", resources.getString("nav_title_3"));

        // vision
        model.addAttribute("title_1", resources.getString("vision.title_1"));
        model.addAttribute("body_1", resources.getString("vision.body_1"));
        model.addAttribute("title_2", resources.getString("vision.title_2"));
        model.addAttribute("body_2", resources.getString("vision.body_2"));
        model.addAttribute("title_3", resources.getString("vision.title_3"));
        model.addAttribute("body_3", resources.getString("vision.body_3"));
        model.addAttribute("title_4", resources.getString("vision.title_4"));
        model.addAttribute("body_4", resources.getString("vision.body_4"));
        model.addAttribute("title_5", resources.getString("vision.title_5"));
        model.addAttribute("body_5", resources.getString("vision.body_5"));
        model.addAttribute("title_6", resources.getString("vision.title_6"));
        model.addAttribute("body_6", resources.getString("vision.body_6"));
        model.addAttribute("title_7", resources.getString("vision.title_7"));
        model.addAttribute("body_7", resources.getString("vision.body_7"));

        // Load vision.jsp
        return "vision";
    }

}
	


