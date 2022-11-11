package com.nguyentran.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyentran.springmvc.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
