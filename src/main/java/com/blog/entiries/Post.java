package com.blog.entiries;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor

public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int postId;
	
	@Column(name="Post_title")
	
	private String title;
	
	@Column(length=100000)
	private String content;
	
	private String imageName;
	private Date addedDate;
	
	@ManyToOne
	@JoinColumn(name="category_Id")
	private Category category;
	
	@ManyToOne
	private User user;
	
	
	
}
