package com.blog.entiries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  @Column(name="user_name",nullable=false,length=100)
  private String name;
  private String email;
  private String password;
  private String about;
  
}
