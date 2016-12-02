package com.community.controller;

import com.community.data.BlogRepository;
import com.community.data.EmailRepository;
import com.community.model.BlogModel;
import com.community.utils.MessageManager;
import com.community.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This is the controller for the administrative section of the site.
 * It will be secured from access by unauthorized users.
 */

@Controller
public class AdminController {

    @Autowired
    private BlogRepository blogRepo;

    @RequestMapping("/admin/index")
    public String index(Model model) {
        MessageManager mgr = MessageManager.getInstance();

        // header & nav (admin)
        ModelUtils.addCommonAdminAttrs(model);

        model.addAttribute("admin_main", "This is where content will be displayed based on left nav selection.");

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
    @RequestMapping(value="/admin/logout", method=RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login.html?logout";
    }

    @RequestMapping(value="/admin/blog", method=RequestMethod.GET)
    public String addBlog(Map<String, Object> model) {
        BlogModel blogForm = new BlogModel();
        model.put("blogForm", blogForm);

        // Load admin/blogEntryForm.jsp view.
        return "/admin/blogEntryForm";
    }

    @RequestMapping(value="/admin/blog", method=RequestMethod.POST)
    public String saveBlog(@ModelAttribute("blogForm") BlogModel blog) {

        // Set blog date to now.
        blog.setCreatedDate(new Date());

        try {
            blogRepo.saveBlogEntry(blog);
        } catch (Exception ex) {
            // TODO handle save errors.
        }

        // Load admin/index.jsp view.
        return "/admin/index";
    }
}


