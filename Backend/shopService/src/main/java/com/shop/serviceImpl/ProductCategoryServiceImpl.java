package com.shop.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.ProductCategory;
import com.shop.repository.ProductCategoryRepository;
import com.shop.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	@Override
	public ProductCategory addCategory(ProductCategory category) {
		// TODO Auto-generated method stub
//		return this.categoryRepository.save(category);
		ProductCategory p= categoryRepository.save(category);
		categoryRepository.flush();
		return p;
	}

	@Override
	public void deleteCategory(String categoryname) {
		ProductCategory p = (ProductCategory) this.categoryRepository.findBycategoryname(categoryname);
		this.categoryRepository.deleteById(p.getCid());
	}

	@Override
	public List<ProductCategory> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public ProductCategory getCategory(Long id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public ProductCategory updateCategory(ProductCategory category) {
		return this.categoryRepository.save(category);
	}

}
