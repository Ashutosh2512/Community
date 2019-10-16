package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="Posts")
public class Post implements PostInterface {
	@Id
	private String id;
	@Field(value="creatorUserName")
	private String creatorUserName;
	@Field(value="creatorUserLink")
	private  String creatorUserLink;
	@Field(value="dateOfCreation")
	private Date dateOfCreation;
	@Field(value="comments")
	private ArrayList<Comment> comments;
	@Field(value="likes")
	private Integer likes;
	@Field(value="dislikes")
	private Integer dislikes;
	/*
	 * This topicID data is used for retrieval of Post from the Posts DataBase and it's
	 * the topic of the question.
	 */ 
	@Field
	private String topicID;
	@Field
	private String content;
	
	public Post(String creatorUserName,String creatorUserLink,
			 String topicID, String content) {
		super();
		this.creatorUserName = creatorUserName;
		this.creatorUserLink=creatorUserLink;
		this.dateOfCreation = new Date();
		this.comments = new ArrayList<Comment>();
		this.likes = 0;
		this.dislikes = 0;
		this.topicID = topicID;
		this.content = content;
	}

	public Post() {
		this.dateOfCreation=new Date();
		this.likes=0;
		this.dislikes=0;
		this.comments=new ArrayList<Comment>();
	}
	@Override
	public String getId() {
		return id;
	}

	public void setId(String postId) {
		id = postId;
	}
    @Override
	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
	@Override
	public String getCreatorUserLink() {
		return creatorUserLink;
	}

	public void setCreatorUserLink(String creatorUserLink) {
		this.creatorUserLink = creatorUserLink;
	}
	@Override
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	@Override
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	@Override
	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public Integer getLikes() {
		return likes;
	}
	@Override
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	@Override
	public Integer getDislikes() {
		return dislikes;
	}
	@Override
	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}
	@Override
	public String getTopicId() {
		return topicID;
	}

	public void setTopicId(String topicID) {
		this.topicID = topicID;
	}
	@Override
	public String getContent() {
		return content;
	}
	@Override
	public void setContent(String content) {
		this.content = content;
	}

	

}
