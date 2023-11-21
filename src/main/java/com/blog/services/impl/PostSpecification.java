package com.blog.services.impl;

import org.springframework.data.jpa.domain.Specification;

import com.blog.entiries.Post;

public class PostSpecification {

	public static Specification<Post> searchByKeyword(String sayt) {
		return (root, query, criteriaBuilder) -> {
			if (sayt == null || sayt.isEmpty()) {
				return null;
			}
			String pattern = "%" + sayt.toLowerCase() + "%";

			return criteriaBuilder.or(
					criteriaBuilder.like(criteriaBuilder.lower(root.get("postId").as(String.class)), pattern),
					criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), pattern),
					criteriaBuilder.like(criteriaBuilder.lower(root.get("content")), pattern));

		};
	}

}
