package com.community.controller;

import com.community.utils.ConfigManager;
import com.community.utils.MessageManager;
import com.community.utils.ModelUtils;
import com.community.utils.StrPair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ResourceBundle;

@Controller
public class IndexController {
 
    @RequestMapping("/index")
    public String hello(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header & nav
        ModelUtils.addCommonAttrs(model);

        // index
        model.addAttribute("title_1", mgr.getMessage("index.title_1"));
        model.addAttribute("body_1", mgr.getMessage("index.body_1"));
        model.addAttribute("title_2", mgr.getMessage("index.title_2"));
        model.addAttribute("body_2", mgr.getMessage("index.body_2"));
        model.addAttribute("title_3", mgr.getMessage("index.title_3"));
        model.addAttribute("body_3", mgr.getMessage("index.body_3"));

        // email
        model.addAttribute("submit_label", mgr.getMessage("email.submit.label"));
        model.addAttribute("success_message", mgr.getMessage("email.subscribe.success_message"));
        model.addAttribute("fail_message", mgr.getMessage("email.subscribe.fail_message"));
        
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header & nav
        ModelUtils.addCommonAttrs(model);

        model.addAttribute("username_label", mgr.getMessage("username_label"));
        model.addAttribute("password_label", mgr.getMessage("password_label"));
        model.addAttribute("username_input_text", mgr.getMessage("username_input_text"));
        model.addAttribute("password_input_text", mgr.getMessage("password_input_text"));
        model.addAttribute("login_error", mgr.getMessage("login_error"));
        model.addAttribute("logout_success", mgr.getMessage("logout_success"));
        model.addAttribute("login_button", mgr.getMessage("login_button"));

        // Load login.jsp
        return "login";
    }

    @RequestMapping("/about")
    public String about(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header & nav
        ModelUtils.addCommonAttrs(model);

        /* about (with a little extra to do email replacement  and google map api here) */

        String googleMapApiKey = "";
        try{
            googleMapApiKey = ConfigManager.getInstance().getSetting(ConfigManager.GOOGLE_MAP_API_KEY);
        } catch(Exception ignore){}

        model.addAttribute("google_map_api_key", googleMapApiKey);//expect empty or valid, not null

        boolean useGoogleMapAPI = googleMapApiKey != null && !googleMapApiKey.trim().isEmpty();
        model.addAttribute("use_google_map", useGoogleMapAPI? "true" : "false");

        String fallbackMap = "";
        try {
            fallbackMap = mgr.getMessage("map_image_name");
        } catch(Exception ignore){}

        model.addAttribute("map_image_name", fallbackMap);

        StrPair[] pairs = new StrPair[]{
                StrPair.of("site.email", mgr.getMessage("site.email"))
        };

        model.addAttribute("title_1", mgr.getMessage("about.title_1"));
        model.addAttribute("body_1", mgr.getMessageWithReplacements("about.body_1", pairs));
        model.addAttribute("title_2", mgr.getMessage("about.title_2"));
        model.addAttribute("body_2", mgr.getMessageWithReplacements("about.body_2", pairs));
        model.addAttribute("title_3", mgr.getMessage("about.title_3"));
        model.addAttribute("body_3", mgr.getMessageWithReplacements("about.body_3", pairs));
        model.addAttribute("title_4", mgr.getMessage("about.title_4"));
        model.addAttribute("body_4", mgr.getMessageWithReplacements("about.body_4", pairs));

        /* Load about.jsp */
        return "about";
    }

    @RequestMapping("/vision")
    public String vision(Model model) {

        MessageManager mgr = MessageManager.getInstance();

        // header & nav
        ModelUtils.addCommonAttrs(model);

        // vision
        model.addAttribute("title_1", mgr.getMessage("vision.title_1"));
        model.addAttribute("body_1", mgr.getMessage("vision.body_1"));
        model.addAttribute("title_2", mgr.getMessage("vision.title_2"));
        model.addAttribute("body_2", mgr.getMessage("vision.body_2"));
        model.addAttribute("title_3", mgr.getMessage("vision.title_3"));
        model.addAttribute("body_3", mgr.getMessage("vision.body_3"));
        model.addAttribute("title_4", mgr.getMessage("vision.title_4"));
        model.addAttribute("body_4", mgr.getMessage("vision.body_4"));
        model.addAttribute("title_5", mgr.getMessage("vision.title_5"));
        model.addAttribute("body_5", mgr.getMessage("vision.body_5"));
        model.addAttribute("title_6", mgr.getMessage("vision.title_6"));
        model.addAttribute("body_6", mgr.getMessage("vision.body_6"));
        model.addAttribute("title_7", mgr.getMessage("vision.title_7"));
        model.addAttribute("body_7", mgr.getMessage("vision.body_7"));

        // Load vision.jsp
        return "vision";
    }

}
	


