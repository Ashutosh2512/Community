package com.Ashutosh.web.CommunityProject.model;

import java.util.Date;

public interface CommentInterface {
    
	public String getContent() ;
	public void setContent(String content) ;
	public String getCreatorUserName();
	public Date getDateOfCreation() ;
	public int getLikes() ;
	public void setLikes(int likes);
	public void setDislikes(int dislikes) ;
	public int getDislikes();
	public Integer getCommentId();
	public void setCommentId(Integer CommentId);
}
