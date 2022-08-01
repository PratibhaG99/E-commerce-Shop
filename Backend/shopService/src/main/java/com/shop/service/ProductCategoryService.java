package com.shop.service;

import java.util.List;

import com.shop.entity.ProductCategory;

public interface ProductCategoryService {
	
	public ProductCategory addCategory(ProductCategory category);
//	public void deleteCategory(Long id);
	public ProductCategory getCategory(Long id);
	public ProductCategory updateCategory(ProductCategory category);
	public List<ProductCategory> getAllCategory();
	void deleteCategory(String categoryname);

}
