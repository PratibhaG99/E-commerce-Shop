package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.ProductCategory;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Long>{

	Object findBycategoryname(String categoryname);

}
