package com.Ashutosh.web.CommunityProject.model;

import java.util.Date;

public class Comment implements CommentInterface{
	
	
	private Integer CommentId;
	
	private String content;
	private String creatorUserName;
	private Date dateOfCreation;
	private Integer likes;
	private Integer dislikes;
    /*
     * This will be used for creating new instances of comment
     */
    public Comment(String content, String creatorUserName) {
		super();
		this.dateOfCreation=new Date();
		this.content = content;
		this.creatorUserName = creatorUserName;
		this.likes = 0;
		this.dislikes = 0;
	}
    
    
    @Override
    public Integer getCommentId() {
		return this.CommentId;
	}
    @Override
	public void setCommentId(Integer commentId) {
		this.CommentId = commentId;
	}
	@Override
	public String getContent() {
		
		return this.content;
	}

	@Override
	public void setContent(String content) {
		
		this.content=content;
	}

	@Override
	public String getCreatorUserName() {
		
		return this.creatorUserName;
	}

	@Override
	public Date getDateOfCreation() {
		
		return this.dateOfCreation;
	}

	@Override
	public int getLikes() {
		
		return this.likes;
	}

	@Override
	public void setLikes(int likes) {
		this.likes=likes;
		
	}

	@Override
	public void setDislikes(int dislikes) {
		this.dislikes=dislikes;
		
	}
 
	public int getDislikes() {
		return this.dislikes;
	}
	
	@Override
	public int hashCode() {
		return this.CommentId;
	}
	@Override
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		Comment c=(Comment)o;
		return this.CommentId==c.CommentId;
	}

}
