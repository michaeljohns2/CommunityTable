package com.community.utils;

import org.springframework.ui.Model;

/**
 * Created by mjohns on 11/27/16.
 */
public class ModelUtils {

    /**
     * Consolidate requirements for common attributes.
     * @param model
     */
    public static void addCommonAttrs(Model model){

        if (model == null) return;
        addHeaderAttrs(model);
        addNavAttrs(model);
    }

    /**
     * Consolidate requirements for common attributes.
     * @param model
     */
    public static void addCommonAdminAttrs(Model model){

        if (model == null) return;
        addCommonAttrs(model);

        //override common
        MessageManager mgr = MessageManager.getInstance();
        model.addAttribute("title", mgr.getMessage("admin.title"));
    }

    /**
     * Consolidate requirements for header attributes.
     * @param model
     */
    public static void addHeaderAttrs(Model model){

        if (model == null) return;

        MessageManager mgr = MessageManager.getInstance();

        model.addAttribute("title", mgr.getMessage("index.title"));
        model.addAttribute("brand", mgr.getMessage("brand"));
    }

    /**
     * Consolidate requirements for navigation attributes.
     * @param model
     */
    public static void addNavAttrs(Model model){

        if (model == null) return;

        MessageManager mgr = MessageManager.getInstance();

        model.addAttribute("nav_title_1", mgr.getMessage("nav_title_1"));
        model.addAttribute("nav_title_2", mgr.getMessage("nav_title_2"));
        model.addAttribute("nav_title_3", mgr.getMessage("nav_title_3"));
    }
}
