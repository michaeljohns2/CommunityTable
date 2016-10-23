package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is a sample controller for Community Table.
 * It retrieves / populates model data and specifies a view.
 */
@Controller
public class AboutController {

	@RequestMapping(value="/about")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "Welcome to Community Table");
		
		return "about";  // resolves to views/about.jsp
	}
}
