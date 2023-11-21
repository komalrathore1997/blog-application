package com.blog.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.blog.entiries.Attechment;
import com.blog.payloads.AttechmentResponse;

public interface AttechmentService {

	Attechment uploadImage(MultipartFile file) throws Exception;

}
 