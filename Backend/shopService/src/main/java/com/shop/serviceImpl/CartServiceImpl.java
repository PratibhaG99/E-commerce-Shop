package com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.entity.Cart;
import com.shop.repository.CartRepository;
import com.shop.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart addToCart(Cart cart){
			cartRepository.save(cart);
			cartRepository.flush();
		return cart;
	}

	@Override
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	@Override
	public int deleteCart(Long cid) {
		cartRepository.deleteById(cid);
		return 1;
	}

}
