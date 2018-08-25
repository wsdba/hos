package com.fym.hos.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fym.hos.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testSave() {
		User user = new User(); 
		user.setId("21111111111112133333333");
		user.setName("12312321321");
		user.setAge(81);
		userService.save(user);
	}

}