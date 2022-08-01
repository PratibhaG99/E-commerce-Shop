package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Product;
import com.shop.entity.ProductCategory;

public interface ProductRepository  extends JpaRepository<Product, Long>{
	public List<Product> findByCategory(ProductCategory category);


	public Product findByproductname(String productname);

}
