package com.nguyentran.springmvc.services;

import java.util.List;
import java.util.Optional;

import com.nguyentran.springmvc.models.Category;


public interface CategoryService {

	List<Category> getAllCates();

	Optional<Category> getCateById(Integer id);

}
