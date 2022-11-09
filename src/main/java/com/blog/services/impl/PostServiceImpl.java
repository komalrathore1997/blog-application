package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entiries.Category;
import com.blog.entiries.Post;
import com.blog.entiries.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.PostDto;
import com.blog.repositories.CategoryRepo;
import com.blog.repositories.PostRepo;
import com.blog.repositories.UserRepo;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modalMapper;

	@Autowired 
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","user id",userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id",categoryId));
		Post post=this.modalMapper.map(postDto,Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		
		return this.modalMapper.map(newPost, PostDto.class);
		
	}
  
	@Override
	public PostDto updatePost(PostDto postDto,Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","Post id",postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost=this.postRepo.save(post);
		return this.modalMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","postId",postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {

		List<Post> posts = this.postRepo.findAll();
		List<PostDto> catDtos = posts.stream().map((p) -> this.modalMapper.map(p, PostDto.class))
				.collect(Collectors.toList());

		return catDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
	    Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","postId",postId));
		return this.modalMapper.map(post,PostDto.class);
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
	    User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
	    List<Post> posts=this.postRepo.findByUser(user);
	    List<PostDto> postDtos=posts.stream().map((post)->this.modalMapper.map(post, PostDto.class)).collect(Collectors.toList());
	    
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
		List<PostDto> postDtos= posts.stream().map((post)->this.modalMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	
	
}
