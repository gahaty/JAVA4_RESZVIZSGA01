package com.citec.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("topics",forumService.findAllTopic());
		return "index";
	}
	
	@GetMapping("/post/{topicId}")
	public String listPost(@PathVariable("topicId") Integer id, Model model) {
		model.addAttribute("topic", forumService.findById(id));
		model.addAttribute("posts",forumService.findAllTopic(id));
		return "forum/post";
	}
	
	@GetMapping("/comment/{postId}")
	public String listComment(@PathVariable("postId") Integer id, Model model) {
		model.addAttribute("postEntity", forumService.findAnEntity(id));
		model.addAttribute("comments", forumService.findAllComment(id));
		return "forum/comment";
	}
	
	
}
