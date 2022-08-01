package com.discount.service;

import java.util.List;

import com.discount.entity.DiscountCoupon;

public interface DiscountCouponService {
	DiscountCoupon addCoupon(DiscountCoupon coupon);
	List<DiscountCoupon> getCoupons();
	void deleteCoupon(Long id);
}
