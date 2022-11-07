package com.blog.services;

import java.util.List;

import com.blog.entiries.Category;
import com.blog.entiries.Post;
import com.blog.payloads.PostDto;

public interface PostService {

	   PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	   PostDto updatePost(PostDto postDto);
	   void deletePost(Integer PostId);
	   List<PostDto> getAllPost();
	   PostDto getPost(Integer postId);
	   //get all post by user
	   List<Post> getPostByUser(Integer userId);
	   //get All post by Category
	   List<Category> getPostByCategory(Integer categoryId);
}
