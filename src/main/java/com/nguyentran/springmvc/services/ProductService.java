package com.nguyentran.springmvc.services;


import java.util.List;
import java.util.Optional;

import com.nguyentran.springmvc.models.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Optional<Product> getProductById(int id);

	void saveProduct(Product product);

	void removeProduct(int id);

}
