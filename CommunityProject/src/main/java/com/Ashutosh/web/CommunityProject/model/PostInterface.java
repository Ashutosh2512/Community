package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;



public interface PostInterface {
	
	public String getCreatorUserName() ;
	public String getCreatorUserLink() ;
	public Date getDateOfCreation() ;
	public void setDateOfCreation(Date dateOfCreation);
	public ArrayList<Comment> getComments() ;
	public Integer getLikes() ;
	public void setLikes(Integer likes) ;
	public Integer getDislikes() ;
	public void setDislikes(Integer dislikes);
	public String getContent();
	public void setContent(String content);
	public String getTopicId();
	public String getId();

}
