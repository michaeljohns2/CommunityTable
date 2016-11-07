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
        
        return "index";
        
    }
 
}
	


