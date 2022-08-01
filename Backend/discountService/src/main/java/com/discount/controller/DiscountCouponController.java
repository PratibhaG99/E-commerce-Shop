package com.discount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discount.entity.DiscountCoupon;
import com.discount.service.DiscountCouponService;

@RestController
@RequestMapping("/discount")
//@CrossOrigin("*")
public class DiscountCouponController {
	
	@Autowired
	DiscountCouponService couponService;
	
	@PostMapping("/")
	public DiscountCoupon addCoupon(@RequestBody DiscountCoupon coupon) {
		System.out.println(coupon);
		return couponService.addCoupon(coupon);
	}
	
	@GetMapping("/")
	public List<DiscountCoupon> getCoupon(){
		return couponService.getCoupons();
	}

	@DeleteMapping("/{did}")
	void deleteCoupon(@PathVariable("did") Long did) {
		couponService.deleteCoupon(did);
	}
}
