package com.Ashutosh.web.CommunityProject.RepoHandler;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Ashutosh.web.CommunityProject.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	

}
