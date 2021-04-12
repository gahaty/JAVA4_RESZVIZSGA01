package com.citec.forum.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.citec.forum.entity.Post;
import com.citec.forum.entity.Topic;
import com.citec.forum.model.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Topic findById(Integer id) {
		return postRepository.findById(id);
	}

	public List<Post> findAllPost(Integer id) {
		return postRepository.findAllPost(id);
	}

	public List<Topic> findAllTopic() {
		return postRepository.findAllTopic();
	}

	// common
	public void insertNewUser(String userName) {
		postRepository.insertNewUser(userName);
	}

	// common
	public Integer findUserById(String userName) {
		return postRepository.findUserById(userName);
	}

	// common
	public Integer getUserId(String userName) {
		return postRepository.getUserId(userName);
	}

	public void newPost(Post p, Integer id) {
		Date date = new java.util.Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		p.setDateTime(timestamp);
		postRepository.newPost(p, id);
	}

	public List<Post> lookFor(Integer id, String lookFor) {
		return postRepository.lookFor(id, lookFor);
	}

}
