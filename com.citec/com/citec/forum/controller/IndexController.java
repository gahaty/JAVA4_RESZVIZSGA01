package com.citec.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citec.service.ForumService;

@Controller
@RequestMapping(path = "/")
public class IndexController {
	
	private ForumService forumService;

	public IndexController(ForumService forumService) {
		this.forumService = forumService;
	}

	@GetMapping("/")
	
	public String listTopic(Model model) {
		model.addAttribute("topics",forumService.findAllTopic());
		return "index";
	}

}
