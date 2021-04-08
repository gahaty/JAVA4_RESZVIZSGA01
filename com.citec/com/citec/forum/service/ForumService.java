package com.citec.forum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citec.forum.entity.Comment;
import com.citec.forum.entity.Post;
import com.citec.forum.entity.Topic;
import com.citec.forum.model.ForumRepository;

@Service
public class ForumService {
	
	private ForumRepository forumRepository;

	public ForumService(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}
	
	public List<Topic> findAllTopic(){
		return forumRepository.findAllTopic();
	}
	
	public Topic findById(Integer id) {
		return forumRepository.findById(id);
	}
	
	public List<Post> findAllTopic(Integer id){
		return forumRepository.findAllPost(id);
	}
	
	public List<Comment> findAllComment(Integer id){
		return forumRepository.findAllComment(id);
	}
	
	public List<Post> findAnEntity(Integer id) {
		return forumRepository.findAnEntity(id);
	}
}
