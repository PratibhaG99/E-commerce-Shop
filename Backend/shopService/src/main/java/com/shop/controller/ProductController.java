package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Product;
import com.shop.entity.ProductCategory;
import com.shop.service.ProductService;

@RestController
@RequestMapping("/shop/product")
//@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Product product1=this.productService.addProduct(product);
		return ResponseEntity.ok(product1);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(this.productService.getProduct());
	}
	
	@GetMapping("/cat/{cid}")
	public List<Product> getProductOfCategory(@PathVariable("cid") Long cid){
		ProductCategory category = new ProductCategory();
		category.setCid(cid);
		return this.productService.getProductOfCategory(category);
	}
	
	@GetMapping("/byId/{pid}")
	public Product getProductById(@PathVariable("pid") Long pid) {
		return productService.getProductById(pid);
	}
	
	@PutMapping("/updateProd")
	public Product updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return product;
	}
	
	@DeleteMapping("/{productname}")
	public void deleteCategory(@PathVariable("productname") String productname) {
		System.out.println(productname);
		this.productService.deleteProduct(productname);

	}
}
