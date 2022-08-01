package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.ProductCategory;
import com.shop.service.ProductCategoryService;

@RestController
@RequestMapping("/shop/category")
//@CrossOrigin("*")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService categoryService;
	
	//add product Category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody ProductCategory category){
		ProductCategory category1=this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	//add product Category
	@GetMapping("/{categoryId}")
	public ProductCategory getCategoryName(@PathVariable("categoryId") Long categoryId) {
		return this.categoryService.getCategory(categoryId);
	}
	
	@GetMapping("/getAllCat")
	public List<ProductCategory> getAllUser() {
		return categoryService.getAllCategory();
		}
	
	@DeleteMapping("/{categoryname}")
	public void deleteCategory(@PathVariable("categoryname") String categoryname) {
		this.categoryService.deleteCategory(categoryname);

	}

}
