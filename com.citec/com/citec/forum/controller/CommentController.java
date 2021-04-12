package com.citec.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citec.forum.entity.Comment;
import com.citec.forum.service.CommentService;

@Controller
@RequestMapping(path = "/comment/")
public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/{postId}")
	public String listComment(@PathVariable("postId") Integer id, Model model) {
		model.addAttribute("postEntity", commentService.findAnEntity(id));
		model.addAttribute("comments", commentService.findAllComment(id));		
		model.addAttribute("postId", id);
		return "forum/comment";
	}
	
	@PostMapping("/new/{postId}")
	public String newComment(@ModelAttribute Comment c, @PathVariable("postId") Integer id, Model model) {
		Integer getUserId = commentService.getUserId(c.getUserName());
		c.setId(getUserId);
		commentService.newComment(c, id);
		return "redirect:/comment/{postId}";
	}
	
	@PostMapping("/{postId}")
	public String searchInComment(@ModelAttribute Comment c, @PathVariable("postId") Integer id, Model model) {
		String lookFor = c.getComment();
		model.addAttribute("postEntity", commentService.findAnEntity(id));
		model.addAttribute("comments", commentService.lookFor(id, lookFor));
		return "forum/comment";	
	}
}
