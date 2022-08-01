package com.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.discount.entity.DiscountCoupon;

public interface DiscountCouponRepository extends JpaRepository<DiscountCoupon, Long>{
	

}
