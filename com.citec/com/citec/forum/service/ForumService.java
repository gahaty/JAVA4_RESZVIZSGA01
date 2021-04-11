package com.citec.forum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citec.forum.entity.Post;
import com.citec.forum.entity.Topic;
import com.citec.forum.model.ForumRepository;

@Service
public class ForumService {

	private ForumRepository forumRepository;

	public ForumService(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}

	public List<Topic> findAllTopic() {
		return forumRepository.findAllTopic();
	}

	// common
	public void insertNewUser(String userName) {
		forumRepository.insertNewUser(userName);
	}

	// common
	public Integer findUserById(String userName) {
		return forumRepository.findUserById(userName);
	}

	// common
	public Integer getUserId(String userName) {
		return forumRepository.getUserId(userName);
	}
	
	public void newTopic(Topic t, Integer id) {
		forumRepository.newTopic(t, id);
	}
}
