package com.citec.forum.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.citec.forum.entity.Comment;
import com.citec.forum.entity.Post;

@Repository
public class CommentRepository {

	private JdbcTemplate template;

	public CommentRepository(JdbcTemplate template) {
		this.template = template;
	}
	
	//Comment
		public List<Comment> findAllComment(Integer id) {
			String query = "SELECT comment.id, user.user_name, comment.comment, comment.datetime FROM comment INNER JOIN user ON user.id = user_name_id WHERE post_id = ?";
			return template.query(query, new BeanPropertyRowMapper<>(Comment.class), id);
		}

		//Comment
		public List<Post> findAnEntity(Integer id) {
			String query = "SELECT post.id, post.title, user.user_name, post.datetime, post.post, post.topic_id FROM post "
					+ "INNER JOIN user ON user_name_id = user.id WHERE post.id = ?";
			return template.query(query, new BeanPropertyRowMapper<>(Post.class), id);
		}

		//Comment/Post
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

		//Comment/Post
		public Integer findUserById(String userName) {
			try {
				String query = "SELECT id FROM user WHERE user_name = ?";
				return template.queryForObject(query, Integer.class, userName);
			} catch (EmptyResultDataAccessException e) {
				return 0;
			}
		}

		//Comment/Post
		public Integer getUserId(String userName) {
			Integer findUserById = findUserById(userName);
			if (!findUserById.equals(0)) {
				return findUserById;
			}
			return insertNewUser(userName);
		}
		
		//Comment
		public void newComment(Comment c, Integer id) {
			String query = "INSERT INTO comment (user_name_id, comment, datetime, post_id) VALUES (?, ?, ?, ?)";
			template.update(query, c.getId(), c.getComment(), c.getDateTime(), id);
		}
}
