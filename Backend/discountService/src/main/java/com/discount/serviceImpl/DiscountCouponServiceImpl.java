package com.discount.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discount.entity.DiscountCoupon;
import com.discount.repository.DiscountCouponRepository;
import com.discount.service.DiscountCouponService;

@Service
public class DiscountCouponServiceImpl implements DiscountCouponService{
	
	@Autowired
	DiscountCouponRepository couponRepository;

	@Override
	public DiscountCoupon addCoupon(DiscountCoupon coupon) {
		couponRepository.save(coupon);
		couponRepository.flush();
		return coupon;
	}

	@Override
	public List<DiscountCoupon> getCoupons() {
		return couponRepository.findAll();
	}

	@Override
	public void deleteCoupon(Long id) {
		couponRepository.deleteById(id);
		
	}

}
