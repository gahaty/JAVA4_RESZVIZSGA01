package com.citec.forum.entity;

public class Comment {
	
	private Integer id;
	private String userName;
	private String comment;
	private String dateTime;
	
	public Comment() {
	}

	public Comment(Integer id, String userName, String comment, String dateTime) {
		this.id = id;
		this.userName = userName;
		this.comment = comment;
		this.dateTime = dateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
