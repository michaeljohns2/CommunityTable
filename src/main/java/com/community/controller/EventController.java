package com.community.controller;

import com.community.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is a sample controller for CommunityTable.
 */
@Controller
public class EventController {

    @RequestMapping(value="/event", method=RequestMethod.GET)
    public String displayEventPage(Model model) {
        Event event = new Event();
        event.setName("Sample community table event");
        model.addAttribute("event", event);

        return "event";
    }

    @RequestMapping(value="/event", method=RequestMethod.POST)
    public String processEvent(@ModelAttribute("event") Event event) {
        System.out.println("Sample posting of a model on form submission");

        return "redirect:index.html";
    }

}
