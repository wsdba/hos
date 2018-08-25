package com.fym.hos.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fym.hos.dao.UserRepository;
import com.fym.hos.entity.User;
import com.fym.hos.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional
	public void save(User user){
		System.out.println("====");
		System.out.println(user);
		System.out.println(userRepository);
		userRepository.saveAndFlush(user);
	}
	
	
}
