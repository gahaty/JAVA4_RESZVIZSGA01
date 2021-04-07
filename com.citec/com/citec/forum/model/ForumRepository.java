package com.citec.forum.model;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citec.forum.entity.Topic;

@Repository
public class ForumRepository {

	private JdbcTemplate template;

	public ForumRepository(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Topic> findAllTopic(){
		String query = "SELECT topic.id, topic.name, user.user_name FROM topic INNER JOIN user ON topic.id = user.id";
		return template.query(query, new BeanPropertyRowMapper<>(Topic.class));
	}
	
}
