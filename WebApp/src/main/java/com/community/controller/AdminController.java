package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ResourceBundle;

/**
 * This is the controller for the administrative section of the site.
 * It will be secured from access by unauthorized users.
 */

@Controller
public class AdminController {

    @RequestMapping("/admin/index")
    public String index(Model model) {

        return "index";
    }
}


