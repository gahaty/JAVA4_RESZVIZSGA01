package com.citec.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citec.forum.entity.Comment;
import com.citec.forum.entity.Post;
import com.citec.forum.service.PostService;

@Controller
@RequestMapping(path = "/post/")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/{topicId}")
	public String listPost(@PathVariable("topicId") Integer id, Model model) {
		model.addAttribute("topic", postService.findById(id));
		model.addAttribute("posts", postService.findAllPost(id));
		model.addAttribute("postId", id);
		return "forum/post";
	}
	
	@PostMapping("/new/{postId}")
	public String newPost(@ModelAttribute Post p, @PathVariable("postId") Integer id, Model model) {
		Integer userId = postService.getUserId(p.getUserName());
		p.setId(userId);
		System.out.println("id: " + p.getId());
		System.out.println("title: " + p.getTitle());
		System.out.println("userName: " + p.getUserName());
		System.out.println("dateTime: " + p.getDateTime());
		System.out.println("post: " + p.getPost());
		System.out.println("topicId: " + p.getTopicId());
		postService.newPost(p, id);
		return "redirect:/post/{postId}";
	}
	
	
}
