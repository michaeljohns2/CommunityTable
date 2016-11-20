package com.community.controller;

import com.community.utils.MessageManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ResourceBundle;

public class AboutController {

        @RequestMapping("/about/index")
        public String hello(Model model) {

            ResourceBundle resources = MessageManager.getInstance().getMessages();

            // header
            model.addAttribute("brand", resources.getString("about.brand"));
            model.addAttribute("motto", resources.getString("about.motto"));

            // nav
            model.addAttribute("first_nav_title", resources.getString("about.first_nav_title"));
            model.addAttribute("second_nav_title", resources.getString("about.second_nav_title"));

            // about
            model.addAttribute("first_title", resources.getString("about.first_title"));
            model.addAttribute("first_body", resources.getString("about.first_body"));
            model.addAttribute("second_title", resources.getString("about.second_title"));
            model.addAttribute("second_body", resources.getString("about.second_body"));

            // Load index.jsp
            return "about";
        }
}

