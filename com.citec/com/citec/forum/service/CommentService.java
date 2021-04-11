package com.citec.forum.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.citec.forum.entity.Comment;
import com.citec.forum.entity.Post;
import com.citec.forum.model.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public List<Comment> findAllComment(Integer id){
		return commentRepository.findAllComment(id);
	}
	
	public List<Post> findAnEntity(Integer id) {
		return commentRepository.findAnEntity(id);
	}
	
	//common
	public void insertNewUser(String userName) {
		commentRepository.insertNewUser(userName);
	}
	
	//common
	public Integer findUserById(String userName) {
		return commentRepository.findUserById(userName);
	}
	
	//common
	public Integer getUserId(String userName) {
		return commentRepository.getUserId(userName);
	}
	
	public void newComment(Comment c, Integer id) {
		Date date = new java.util.Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		c.setDateTime(timestamp);
		commentRepository.newComment(c, id);
	}
}
