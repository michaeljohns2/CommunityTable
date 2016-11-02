package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class IndexController {
 
    @RequestMapping("/index")
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Welcome to Community Tables");
        
        return "index";
        
    }
 
}
	

