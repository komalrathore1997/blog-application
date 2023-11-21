package com.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entiries.Category;
import com.blog.entiries.Post;
import com.blog.entiries.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

	Page<Post> findAll(Specification<Post> searchSpec, Pageable pageable);
}
