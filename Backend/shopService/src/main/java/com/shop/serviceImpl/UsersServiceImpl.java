package com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Users;
import com.shop.helper.UserFoundException;
import com.shop.repository.UsersRepository;
import com.shop.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersRepository userRepository;
	
	@Override
	public Users addUser(Users user) throws Exception {
		Users temp = userRepository.findByUsername(user.getUsername());
		if(temp!=null) {
			System.out.println("User already exists !!");
			throw new UserFoundException();
		}
		else {
			temp=userRepository.save(user);
			userRepository.flush();
		}
		return temp;
	}

	@Override
	public Users getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<Users> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<Users> getUserbyEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public Users updateUser(Users user) {
		return this.userRepository.save(user);
	}
}
