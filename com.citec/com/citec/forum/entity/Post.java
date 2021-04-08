package com.citec.forum.entity;

public class Post {

	private Integer id;
	private String title;
	private String userName;
	private String dateTime;
	private String post;
	private Integer topicId;
	
	public Post() {
	}

	public Post(Integer id, String title, String userName, String dateTime, String post, Integer topicId) {
		this.id = id;
		this.title = title;
		this.userName = userName;
		this.dateTime = dateTime;
		this.post = post;
		this.topicId = topicId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

}


