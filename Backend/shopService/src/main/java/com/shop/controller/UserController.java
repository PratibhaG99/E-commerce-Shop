package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.LoginForm;
import com.shop.entity.Users;
import com.shop.serviceImpl.UsersServiceImpl;

@RestController
@RequestMapping("/shop/user")
//@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UsersServiceImpl usersService;
	
	@PostMapping("/")
	public Users addUser(@RequestBody Users user) throws Exception {
		return usersService.addUser(user);	
	}
	
	@PostMapping("/login")
	public Users getUserbyEmail(@RequestBody LoginForm loginForm) {
		Users user = usersService.getUser(loginForm.getUsername());
		if(user==null) {
			System.out.println("User Not Found");
			return null;
		}
		String a= user.getPassword();
		String b= loginForm.getPassword();
		if(a.equals(b)) {
			return user;
		}
		else {
			System.out.println("Password Incorrect");
			return null;
		}
	}
	

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		usersService.deleteUser(userId);
	}
	
	@GetMapping("/{username}")
	public Users getUser(@PathVariable("username") String username) {
		return usersService.getUser(username);
	}
	
	@GetMapping("/")
	public List<Users> getAllUser() {
		return usersService.getAllUser();
	}
	
	@PutMapping("/")
	public Users updateUser(@RequestBody Users user) {
		return this.usersService.updateUser(user);
	}

}
