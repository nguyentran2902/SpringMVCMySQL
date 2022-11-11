package com.nguyentran.springmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentran.springmvc.models.Product;
import com.nguyentran.springmvc.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void removeProduct(int id) {
		
		productRepository.deleteById(id);
	}

}
