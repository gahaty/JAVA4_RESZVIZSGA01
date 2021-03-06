package com.citec.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citec.forum.entity.Topic;
import com.citec.forum.service.ForumService;

@Controller
@RequestMapping(path = "/")
public class IndexController {
	
	private ForumService forumService;

	public IndexController(ForumService forumService) {
		this.forumService = forumService;
	}

	@GetMapping("/")
	public String listTopic(Model model) {
		model.addAttribute("topic",forumService.findAllTopic());
		return "index";
	}
	
	@PostMapping("/new")
	public String newTopic(@ModelAttribute Topic t, Model model) {
	Integer id = forumService.getUserId(t.getUserName());
	t.setId(id);
	forumService.newTopic(t, id);
	return "redirect:/";
	}
	
	@PostMapping("/")
	public String searchInPost(@ModelAttribute Topic t, Model model) {
		String lookFor = t.getName();
		model.addAttribute("topic", forumService.lookFor(lookFor));
		return "index";
	}
}
