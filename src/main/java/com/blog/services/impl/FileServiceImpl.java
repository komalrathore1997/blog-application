package com.blog.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		String name = file.getOriginalFilename();

		String randomId = UUID.randomUUID().toString();
		String fileName = randomId.concat(name.substring(name.lastIndexOf(".")));
		String filePath = path + File.separator + fileName;

		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, Paths.get(filePath));
		}

		return fileName;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = Paths.get(path, fileName).toString();
		return new FileInputStream(fullPath);
	}
}
