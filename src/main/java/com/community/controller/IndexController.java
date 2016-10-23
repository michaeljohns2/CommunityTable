package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is a sample controller for CommunityTable.
 */
@Controller
public class IndexController {

    @RequestMapping(value="/index")
    public String sayHello(Model model) {

        return "forward:index.jsp";
    }
}
