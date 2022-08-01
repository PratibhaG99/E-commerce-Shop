package com.shop.service;

import java.util.List;


import com.shop.entity.Product;
import com.shop.entity.ProductCategory;

public interface ProductService {
	
	public Product addProduct(Product product);
	public void deleteProduct(String productname);
	public List<Product> getProduct();
	public Product getProductById(Long id);
	public Product updateProduct(Product product);
	public List<Product> getProductOfCategory(ProductCategory category);
}
