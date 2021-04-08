package com.citec.forum.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.citec.forum.entity.Comment;
import com.citec.forum.entity.Post;
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
	
	public Topic findById(Integer id) {
		String query = "SELECT name FROM topic WHERE id = ?";
		return template.queryForObject(query, new RowMapper<Topic>(){

			@Override
			public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
				Topic topic = new Topic();
				topic.setTopicName(rs.getString("name"));
				return topic;
			}	
		},id);
	}
	
	public List<Post> findAllPost(Integer id){
		String query = "SELECT post.id, post.title, user.user_name, post.datetime, topic.name FROM post INNER JOIN user ON user.id = post.id INNER JOIN topic ON topic.id = post.topic_id WHERE post.topic_id = ?";
		return template.query(query, new BeanPropertyRowMapper<>(Post.class), id);
	}
	
	public List<Comment> findAllComment(Integer id){
		String query = "SELECT comment.id, user.user_name, comment.comment, comment.datetime FROM comment INNER JOIN user ON user.id = user_name_id WHERE post_id = ?";
		return template.query(query, new BeanPropertyRowMapper<>(Comment.class), id);
	}
	
	public List<Post> findAnEntity(Integer id) {
	String query = "SELECT post.id, post.title, user.user_name, post.datetime, post.post, post.topic_id FROM post INNER JOIN user ON user_name_id = user.id WHERE post.id = ?";
		return template.query(query, new BeanPropertyRowMapper<>(Post.class), id);
	}
}
