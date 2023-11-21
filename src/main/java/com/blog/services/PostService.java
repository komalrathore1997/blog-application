package com.blog.services;

import java.util.List;

import com.blog.entiries.PostResponse;
import com.blog.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String orderBy, String sayt);

	PostDto getPostById(Integer postId);

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> getPostByCategory(Integer categoryId);

}
