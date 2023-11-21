package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entiries.Attechment;

@Repository
public interface AttechmentRepo extends JpaRepository<Attechment, String> {

}
