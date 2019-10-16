package com.Ashutosh.web.CommunityProject.Service;

import com.Ashutosh.web.CommunityProject.model.Post;

public interface PostService {
	
	public Post savePost(Post p);
	public Post updatePost(Post p);
	public Post getPost(String _postId);
	public void DeletePost(String _postId);

}
