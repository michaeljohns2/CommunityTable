package com.community.controller;

import com.community.data.BlogRepository;
import com.community.model.BlogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by plaskorski on 12/6/16.
 */
@Controller
public class BlogController {

    private final String blogName = "TableTalk";
    // private final String blogName = "blog";

    @Autowired
    BlogRepository blogRepo;

    @RequestMapping(value="/"+blogName, method= RequestMethod.GET)
    public String displayBlogEntries(Model model) {
        List<BlogModel> blogs = blogRepo.getAllBlogs();
        model.addAttribute("listBlogModel",blogs);
        return "blogSummaries";
    }

    @RequestMapping(value="/"+blogName, method= RequestMethod.GET)
    public String displayBlogEntry(@RequestParam(name="id") String id, Model model) {
        BlogModel blog = blogRepo.getBlog(id);
        if (blog == null) {
            return "blogNotFound";
        } else {
            model.addAttribute("blogModel", blog);
            return "blogEntry";
        }
    }
}
