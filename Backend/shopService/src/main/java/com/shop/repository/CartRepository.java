package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
