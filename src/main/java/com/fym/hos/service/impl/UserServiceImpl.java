package com.fym.hos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fym.hos.dao.UserRepository;
import com.fym.hos.entity.TUser;
import com.fym.hos.service.QualityService;
import com.fym.hos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
   
    
    
    @Transactional
    public String login(String account,String password) {
    	List<TUser> userList =  userRepository.findAll();
    	for (TUser tUser2 : userList) {
			if(account.equals(tUser2.getAccount())&&password.equals(tUser2.getPassword())){
				return "success";
			}
		}
        return "false";
    }
}
