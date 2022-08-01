package com.shop.service;

import java.util.List;

import com.shop.entity.Cart;
import com.shop.helper.AlreadyInCart;

public interface CartService {
	
	public Cart addToCart(Cart cart) throws AlreadyInCart;
	public List<Cart> getAllCart();
	int deleteCart(Long cid);
}
