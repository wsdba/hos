package com.fym.hos.service;

import com.fym.hos.entity.TUser;

/**
 * 医生服务类
 * 
 * @author fym
 * @since 2018-08-26
 */
public interface UserService {

	String login(String account,String password);
	
}
