package com.blog.services;

import java.util.List;

import com.blog.entiries.Category;
import com.blog.entiries.Post;
import com.blog.payloads.PostDto;

public interface PostService {

	   PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	   PostDto updatePost(PostDto postDto,Integer postId);
	   void deletePost(Integer postId);
	   List<PostDto> getAllPost();
	   PostDto getPostById(Integer postId);
	   //get all post by user
	   List<PostDto> getPostByUser(Integer userId);
	   //get All post by Category
	   List<PostDto> getPostByCategory(Integer categoryId);
}
