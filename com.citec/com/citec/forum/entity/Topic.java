package com.citec.forum.entity;

public class Topic {
	
	private Integer id;
	private String name;
	private String userName;
	private String topicName;
	
	public Topic() {}

	public Topic(Integer id, String name, String userName, String topicName) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.topicName = topicName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
}
