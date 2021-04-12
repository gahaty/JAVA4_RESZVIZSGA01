package com.citec.forum.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.citec.forum.entity.Post;
import com.citec.forum.entity.Topic;

@Repository
public class PostRepository {

	private JdbcTemplate template;

	public PostRepository(JdbcTemplate template) {
		this.template = template;
	}

	// Topic
	public Topic findById(Integer id) {
		String query = "SELECT name FROM topic WHERE id = ?";
		return template.queryForObject(query, new RowMapper<Topic>() {

			@Override
			public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
				Topic topic = new Topic();
				topic.setTopicName(rs.getString("name"));
				return topic;
			}
		}, id);
	}

	// Post
	public List<Post> findAllPost(Integer id) {
		String query = "SELECT post.id, post.title, user.user_name, post.datetime, topic.name FROM post INNER JOIN user ON user_name_id = user.id INNER JOIN topic ON topic.id = post.topic_id WHERE post.topic_id = ?";
		return template.query(query, new BeanPropertyRowMapper<>(Post.class), id);
	}

	public List<Topic> findAllTopic() {
		String query = "SELECT topic.id, topic.name, user.user_name FROM topic INNER JOIN user ON topic.id = user.id";
		return template.query(query, new BeanPropertyRowMapper<>(Topic.class));
	}

	public void newPost(Post p, Integer id) {
		String query = "INSERT INTO post (user_name_id, title, post, datetime, topic_id) VALUES (?, ?, ?, ?, ?)";
		template.update(query, p.getId(), p.getTitle(), p.getPost(), p.getDateTime(), id);
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
	
	public List<Post> lookFor(Integer id, String lookFor) {
		String query = "SELECT post.id, post.title, user.user_name, post.datetime, topic.name FROM post INNER JOIN user ON user_name_id = user.id INNER JOIN topic ON topic.id = post.topic_id WHERE post.topic_id = ? AND (title LIKE '%" + lookFor +"%' OR user.user_name LIKE '%" + lookFor +"%')";
		return template.query(query, new BeanPropertyRowMapper<>(Post.class), id);
	}
}
