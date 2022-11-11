package com.nguyentran.springmvc.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentran.springmvc.models.Category;
import com.nguyentran.springmvc.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCates() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> getCateById(Integer id) {
		
		return categoryRepository.findById(id);
	}

}
