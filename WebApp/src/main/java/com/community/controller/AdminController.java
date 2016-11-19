package com.community.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

/**
 * This is the controller for the administrative section of the site.
 * It will be secured from access by unauthorized users.
 */

@Controller
public class AdminController {

    @RequestMapping("/admin/index")
    public String index(Model model) {
        // Load admin/index.jsp view.
        return "/admin/index";
    }

    /**
     * This admin action logs the user out.
     *
     * @param request
     * @param response
     * @return  Redirects to login screen.
     */
    @RequestMapping(value="/admin/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login.html?logout";
    }
}


