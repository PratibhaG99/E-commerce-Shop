package com.shop.service;

import java.util.List;

import com.shop.entity.Wishlist;

public interface WishlistService {

	public Wishlist addToWishlist(Wishlist wishlist);
	public List<Wishlist> getWishlist();
	public int deleteFromWishList(Long wid);
}
