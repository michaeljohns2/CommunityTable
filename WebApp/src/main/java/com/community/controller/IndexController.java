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
        model.addAttribute("greeting", resources.getString("index.greeting"));
        model.addAttribute("body", resources.getString("index.body"));
        model.addAttribute("submitlbl", resources.getString("email.submit.label"));
        model.addAttribute("success", resources.getString("email.subscribe.success"));
        model.addAttribute("fail", resources.getString("email.subscribe.fail"));
 	model.addAttribute("brand", resources.getString("index.brand"));
        model.addAttribute("motto", resources.getString("index.motto"));
        model.addAttribute("first_title", resources.getString("index.first_title"));
        model.addAttribute("first_body", resources.getString("index.first_body"));
        model.addAttribute("second_title", resources.getString("index.second_title"));
        model.addAttribute("second_body", resources.getString("index.second_body"));
        
        return "index";
        
    }
 
}
	


