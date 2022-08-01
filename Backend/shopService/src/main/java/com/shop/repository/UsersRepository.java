package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Users findByUsername(String username);

	List<Users> findByEmail(String email);

}
