package com.citec.forum.model;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.citec.forum.entity.Post;
import com.citec.forum.entity.Topic;

public class TopicRepository {
	
	private JdbcTemplate template;

	public TopicRepository(JdbcTemplate template) {
		this.template = template;
	}

	// Comment/Post/Topic
	public Integer insertNewUser(String userName) {
		String query = "INSERT INTO User (user_name) VALUES (?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(conn -> {
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, userName);
			return ps;
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	// Comment/Post/Topic
	public Integer findUserById(String userName) {
		try {
			String query = "SELECT id FROM user WHERE user_name = ?";
			return template.queryForObject(query, Integer.class, userName);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	// Comment/Post/Topic
	public Integer getUserId(String userName) {
		Integer findUserById = findUserById(userName);
		if (!findUserById.equals(0)) {
			return findUserById;
		}
		return insertNewUser(userName);
	}
	
	public void newTopic(Topic t, Integer id) {
		String query = "INSERT INTO post (name, user_name_id) VALUES (?, ?)";
		template.update(query, t.getName(), id);
	}

}
