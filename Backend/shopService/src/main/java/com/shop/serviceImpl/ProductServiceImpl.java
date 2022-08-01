package com.shop.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Product;
import com.shop.entity.ProductCategory;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
//		return this.productRepository.save(product);
		Product p= productRepository.save(product);
		productRepository.flush();
		return p;
	}

	@Override
	public void deleteProduct(String productname) {
		Product p = (Product) this.productRepository.findByproductname(productname);
		System.out.println(p);
		this.productRepository.deleteById(p.getPid());
	}

	@Override
	public List<Product> getProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public List<Product> getProductOfCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return this.productRepository.findByCategory(category);
	}

}
