package com.nguyentran.springmvc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nguyentran.springmvc.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
