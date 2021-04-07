package com.citec.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
