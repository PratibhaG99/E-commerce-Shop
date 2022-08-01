package com.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shop.service.CartService;
import com.shop.service.ProductCategoryService;
import com.shop.service.ProductService;
import com.shop.serviceImpl.UsersServiceImpl;

@SpringBootApplication
public class ShopServiceApplication implements CommandLineRunner{


	@Autowired
	UsersServiceImpl usersService;
	@Autowired
	ProductCategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	CartService cartService;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting...");
		
//		Users user = new Users();
//		user.setEmail("pratibha@gmail.com");
//		user.setPhone("223782");
//		user.setUsername("Admin");
//		user.setFirstName("Pratibha");
//		user.setLastName("Gupta");
//		user.setRole("Admin");
//		user.setAddress("Rajasthan");
//		user.setPassword("admin");
//		Users userTemp = usersService.addUser(user);
//		System.out.println(userTemp);
//		
//		Users user = new Users();
//		user.setEmail("seema@gmail.com");
//		user.setPhone("4328747");
//		user.setUsername("Seema");
//		user.setFirstName("Seema");
//		user.setLastName("Rajput");
//		user.setRole("User");
//		user.setAddress("Delhi");
//		user.setPassword("seema");
//		Users userTemp1 = usersService.addUser(user);
//		System.out.println(userTemp1);
		
//		ProductCategory p2 =new ProductCategory();
//		p2.setCategoryname("Planter");
//		categoryService.addCategory(p2);
//		ProductCategory p1 =new ProductCategory();
//		p1.setCid(3L);
//		p1.setCategoryname("Planter");
//		
//		Product p=new Product();
//		p.setCategory(p1);
//		p.setDescription("Test");
//		p.setPid(4L);
//		p.setPrice("345");
//		p.setProductname("Lamp Test");
//		p.setStock("45");
//		
//		Cart cart=new Cart();
//		cart.setCartid(3L);
//		cart.setCount(1);
//		cart.setProduct(p);
//		cart.setUser(user);
//		cartService.addToCart(cart);
		
	}

}
