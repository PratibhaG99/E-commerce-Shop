package com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Wishlist;
import com.shop.repository.WishlistRepository;
import com.shop.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	WishlistRepository wishlistRepository;
	
	@Override
	public Wishlist addToWishlist(Wishlist wishlist) {
		this.wishlistRepository.save(wishlist);
		this.wishlistRepository.flush();
		return wishlist;
	}

	@Override
	public List<Wishlist> getWishlist() {
		// TODO Auto-generated method stub
		return this.wishlistRepository.findAll();
	}

	@Override
	public int deleteFromWishList(Long wid) {
		wishlistRepository.deleteById(wid);
		return 1;
	}

}
