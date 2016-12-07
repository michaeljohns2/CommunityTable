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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
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
    public String index(Model model, HttpServletRequest request) {
        MessageManager mgr = MessageManager.getInstance();

        // Check for a confirmation message in session.
        String confirmation = (String) request.getSession().getAttribute("admin_confirmation");
        if (confirmation != null)
        {
            // Copy to display attribute and delete from session.
            model.addAttribute("admin_confirmation", confirmation);
            request.getSession().setAttribute("admin_confirmation", null);
        }

        // header & nav (admin)
        ModelUtils.addCommonAdminAttrs(model);

        model.addAttribute("admin_main", mgr.getMessage("admin.maincontent"));

        List<BlogModel> blogs = blogRepo.getAllBlogs();
        model.addAttribute("blogList", blogs);

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
        return "redirect:/admin/index.html";
    }

    @RequestMapping(value="/admin/deleteBlog", method=RequestMethod.GET)
    public String deleteBlog(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id != null) {
            blogRepo.deleteBlog(id);
        }

        MessageManager mgr = MessageManager.getInstance();
        model.addAttribute("admin_main", mgr.getMessage("admin.maincontent"));

        request.getSession().setAttribute("admin_confirmation", mgr.getMessage("admin.blog_delete_confirmation"));

        // Load admin/index.jsp view.
        return "redirect:/admin/index.html";
    }


}


