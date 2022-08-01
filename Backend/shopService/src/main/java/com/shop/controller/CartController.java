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

import com.shop.entity.Cart;
import com.shop.helper.AlreadyInCart;
import com.shop.service.CartService;

@RestController
@RequestMapping("/shop/cart")
//@CrossOrigin("*")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/")
	public ResponseEntity<?> addToCart(@RequestBody Cart cart) throws AlreadyInCart{
		Cart c = cartService.addToCart(cart);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/")
	public List<Cart> getAllCart(){
		return cartService.getAllCart();
	}
	
	@DeleteMapping("/{cid}")
	public int deleteCart(@PathVariable("cid") Long cid) {
		return cartService.deleteCart(cid);
	}

}
