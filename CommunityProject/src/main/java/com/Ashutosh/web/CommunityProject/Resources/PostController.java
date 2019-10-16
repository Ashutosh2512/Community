package com.Ashutosh.web.CommunityProject.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.web.CommunityProject.Service.PostServiceImpl;
import com.Ashutosh.web.CommunityProject.model.Comment;
import com.Ashutosh.web.CommunityProject.model.Post;

@RestController
@RequestMapping(path="Posts")
public class PostController {
	@Autowired
	private PostServiceImpl psi;
	
	@PostMapping
	public Post save(@RequestBody Post p) {
		return psi.savePost(p);
	}
	@PutMapping(path="{postId}")
	public Post updatePost(@PathVariable(name="postId") String postId,@RequestBody Post p) {
		return psi.updatePost(p);
	}
	@PutMapping(path="{postId}/content")
	public String updatePostContent(@RequestBody String content,@PathVariable(name="postId") String postId) {
		return psi.updatePostContent(content, postId);
	}
	//to update the likes of the post by 1
	@PutMapping(path="{postId}/likes")
	public Integer updatePostLikes(@PathVariable(name="postId") String postId) {
		return psi.updatePostlikes( postId);
	}
	//to update the dislikes of the post by 1
	@PutMapping(path="{postId}/dislikes")
	public Integer updatePostDisikes(@PathVariable(name="postId") String postId) {
		return psi.updatePostdislikes( postId);
	}
	//to update the content of comment
	@PutMapping(path="{postId}/comments/content/{commentId}")
	public Comment updateCommentContent(@RequestBody String content,@PathVariable(name="postId") String postId,@PathVariable(name="commentId") Integer commentId) {
		return psi.updateCommentContent(commentId, content, postId);
	}
	//to update the likes of comment by 1
	@PutMapping(path="{postId}/comments/likes/{commentId}")
	public Integer updateCommentlikes(@PathVariable(name="postId") String postId,@PathVariable(name="commentId") Integer commentId) {
		return psi.updateCommentlikes(commentId, postId);
	}
	//to update the dislikes on comment by 1
	@PutMapping(path="{postId}/comments/dislikes/{commentId}")
	public Integer updateCommentdislikes(@PathVariable(name="postId") String postId,@PathVariable(name="commentId") Integer commentId) {
		return psi.updateCommentdislikes(commentId, postId);
	}
	@GetMapping(path="{_postId}")
	public Post get(@PathVariable(name="_postId") String _postId) {
		return psi.getPost(_postId);
	}
	@GetMapping()
		public List<Post> getAllPost(){
			return psi.getAllPost();
		}
	
	@DeleteMapping(path="{_postId}")
	public void Delete(@PathVariable(name="_postId") String _postId) {
		psi.DeletePost(_postId);
	}
}
