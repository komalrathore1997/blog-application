package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entiries.Category;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.repositories.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepo categoryRepo;
	 
	@Autowired
	private ModelMapper ModalMapper;
	
	@Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
    	Category category=this.dtoToCategory(categoryDto);
    	Category saveCategory=this.categoryRepo.save(category);
    	
		return this.CategoryToDto(saveCategory);
	}
    
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
    	Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
    	category.setCategoryId(categoryDto.getCategoryId());
    	category.setCategoryTital(categoryDto.getCategoryTital());
    	category.setCategoryDescription(categoryDto.getCategoryDescription());
    	Category updateCategory=this.categoryRepo.save(category);
    	CategoryDto categoryDto1=this.CategoryToDto(updateCategory);
    	return categoryDto1;
    }
    
    @Override
    public void deleteCategory(Integer categoryId) {
    	Category category=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
    	this.categoryRepo.delete(category);
    	
    }
    
    @Override
    public CategoryDto getCategory(Integer categoryId) {
    	Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));
    	
    	return this.CategoryToDto(category);
    }
    
    @Override
    public List<CategoryDto> getAllCategory() {
    	List<Category> categories=this.categoryRepo.findAll();
    	
    	List<CategoryDto> categoryDtos=categories.stream().map(category -> this.CategoryToDto(category)).collect(Collectors.toList());
    	
    	return categoryDtos;
    }
    
    private Category dtoToCategory(CategoryDto categoryDto) {
//    	Category category=new Category();
//    	category.setCategoryId(categoryDto.getCategoryId());
//    	category.setCategoryTital(categoryDto.getCategoryTital());
//    	category.setCategoryDescription(categoryDto.getCategoryDescription());
//    
//		return category;
    	Category category=this.ModalMapper.map(categoryDto, Category.class);
    	return category;
    			
    	
    }
    
    
    private CategoryDto CategoryToDto(Category category) {
//    	CategoryDto categoryDto=new CategoryDto();
//    	categoryDto.setCategoryId(category.getCategoryId());
//    	categoryDto.setCategoryTital(category.getCategoryTital());
//    	categoryDto.setCategoryDescription(category.getCategoryDescription());
//    
//		return categoryDto;
    	CategoryDto categoryDto=this.ModalMapper.map(category, CategoryDto.class);
    	return categoryDto;
    	
    }
    
}
