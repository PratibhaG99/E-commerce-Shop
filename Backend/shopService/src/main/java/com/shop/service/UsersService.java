package com.shop.service;

import java.util.List;

import com.shop.entity.Users;

public interface UsersService {
	
	Users addUser(Users user) throws Exception;
//	String deleteUser(Person user);
	Users getUser(String username);
	List<Users> getUserbyEmail(String email);
	List<Users> getAllUser();
	void deleteUser(Long id);
	Users updateUser(Users user);

}
