package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class IndexController {
 
    @RequestMapping("/index")
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Community Tables");
        model.addAttribute("body", "The most vulnerable among us often suffer alone, with limited resources and often without hope. Community Tables builds highly localizable software to strengthen and renew the social contract among neighbors, so that no one struggles in isolation again.");
        
        return "index";
        
    }
 
}
	


