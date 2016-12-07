package com.community.controller;

import com.community.data.BlogRepository;
import com.community.model.BlogModel;
import com.community.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by plaskorski on 12/6/16.
 */
@Controller
public class BlogController {

    // KJD for now just using static mapping paths to get it to run...
    //private final String blogName = "TableTalk";
    // private final String blogName = "blog";

    @Autowired
    BlogRepository blogRepo;

    @RequestMapping(value="/blogs", method= RequestMethod.GET)
    public String displayBlogEntries(Model model) {
        // header & nav
        ModelUtils.addCommonAttrs(model);

        List<BlogModel> blogs = blogRepo.getAllBlogs();
        model.addAttribute("blogList", blogs);
        return "blogSummaries";
    }

    @RequestMapping(value="/blog/{id}", method= RequestMethod.GET)
    public String displayBlogEntry(@PathVariable("id") String id, Model model) {
        // header & nav
        ModelUtils.addCommonAttrs(model);

        BlogModel blog = blogRepo.getBlog(id);
        model.addAttribute("blogEntry", blog);

        if (blog == null) {
            return "blogNotFound";
        } else {
            model.addAttribute("blogModel", blog);
            return "blogDetail";
        }
    }
}
