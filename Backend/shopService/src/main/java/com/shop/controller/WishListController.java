package com.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.entity.Wishlist;
import com.shop.service.WishlistService;

@RestController
@RequestMapping("/shop/wishlist")
//@CrossOrigin("*")
public class WishListController {
	
	@Autowired
	WishlistService wishlistService;
	
	@PostMapping("/")
	public Wishlist addToWishlist(@RequestBody Wishlist wishlist) {
		return wishlistService.addToWishlist(wishlist);
	}
	
	@GetMapping("/")
	public List<Wishlist> getWishList(){
		return wishlistService.getWishlist();
	}
	
	@DeleteMapping("/{wid}")
	public int deleteFromWishList(@PathVariable("wid") Long wid) {
		return wishlistService.deleteFromWishList(wid);
	}

}
