package com.Ashutosh.web.CommunityProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.web.CommunityProject.RepoHandler.PostRepository;
import com.Ashutosh.web.CommunityProject.RepoHandler.ProfileRepository;
import com.Ashutosh.web.CommunityProject.model.Comment;
import com.Ashutosh.web.CommunityProject.model.Post;
import com.Ashutosh.web.CommunityProject.model.Profile;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository pr;
	@Autowired
	private ProfileRepository prr;
	/*
	 * savePost saves the post into the db as well as adds 
	 * the topicId to the profile of the creator.
	 */
	@Override
	public Post savePost(Post p) {
		// TODO Auto-generated method stub
		Optional<Profile> optProfile=prr.findById(p.getCreatorUserName());
		Profile p1=optProfile.get();
		ArrayList<String> answers=p1.getAnswers();
		answers.add(p.getTopicId());
		p1.setAnswers(answers);
		prr.save(p1);
		return pr.save(p);
	}

	@Override
	public Post updatePost(Post p) {
		// TODO Auto-generated method stub
		return pr.save(p);
	}

	@Override
	public Post getPost(String _postId) {
		// TODO Auto-generated method stub
		Optional<Post> OptPost=pr.findById(_postId);
		if(OptPost.isPresent()) {
			return OptPost.get();
		}
		return null;
	}
	public List<Post> getAllPost(){
		return pr.findAll();
	}
	/*
	 * DeletePost deletes the post from the db as well as the userprofile to which  
	 * the post belonged.
	 */
	@Override
	public void DeletePost(String _postId) {
		// TODO Auto-generated method stub
		Post p=this.getPost(_postId);
		Optional<Profile> optProfile=prr.findById(p.getCreatorUserName());
		Profile userProfile=optProfile.get();
		ArrayList<String> answers=userProfile.getAnswers();
		answers.remove(p.getTopicId());
		userProfile.setAnswers(answers);
		prr.save(userProfile);
		pr.deleteById(_postId);
	}
	public String updatePostContent(String content,String postId) {
		Post p=this.getPost(postId);
		p.setContent(content);
		pr.save(p);
		return content;
	}
	public Integer updatePostlikes(String postId) {
		Post p=this.getPost(postId);
		Integer likes=p.getLikes();
		p.setLikes(likes+1);
		pr.save(p);
		return likes+1;
	}
	public Integer updatePostdislikes(String postId) {
		Post p=this.getPost(postId);
		Integer dislikes=p.getDislikes();
		p.setDislikes(dislikes+1);
		return dislikes+1;
	}
	
	public Comment updateCommentContent(Integer commentId,String content,String postId) {
		Post p=this.getPost(postId);
		ArrayList<Comment> commentslist=p.getComments();
		int l=commentslist.size(),j;
		Comment c=null;
		for(j=0;j<l;j++) {
			c=commentslist.get(j);
			if(c.getCommentId()==commentId) {
        		break;
        	}
		}
		c.setContent(content);
		commentslist.set(j, c);
		p.setComments(commentslist);
		this.updatePost(p);
		return c;
	}
	public Integer updateCommentlikes(Integer commentId,String postId) {
		Post p=this.getPost(postId);
		ArrayList<Comment> commentslist=p.getComments();
		int l=commentslist.size(),j;
		Comment c=null;
		for(j=0;j<l;j++) {
			c=commentslist.get(j);
			if(c.getCommentId()==commentId) {
        		break;
        	}
		}
		Integer likes=c.getLikes();
		c.setLikes(likes+1);
		commentslist.set(j, c);
		p.setComments(commentslist);
		this.updatePost(p);
		return likes+1;
	}
	public Integer updateCommentdislikes(Integer commentId,String postId) {
		Post p=this.getPost(postId);
		ArrayList<Comment> commentslist=p.getComments();
		int l=commentslist.size(),j;
		Comment c=null;
		for(j=0;j<l;j++) {
			c=commentslist.get(j);
			if(c.getCommentId()==commentId) {
        		break;
        	}
		}
		Integer dislikes=c.getDislikes();
		c.setDislikes(dislikes+1);
		commentslist.set(j, c);
		p.setComments(commentslist);
		this.updatePost(p);
		return dislikes+1;
	}
	public Comment saveComment(Comment c,String postId) {
		Post p=this.getPost(postId);
		ArrayList<Comment> commentslist=p.getComments();
        int l=commentslist.size(),j;
        boolean b=false;
        c.setCommentId(l+1);
    	commentslist.add(c);
        p.setComments(commentslist);
		this.updatePost(p);
		return c;
	}

}
