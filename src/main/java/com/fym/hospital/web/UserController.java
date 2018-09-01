package com.fym.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.entity.TQuality;
import com.fym.hos.entity.TUser;
import com.fym.hos.service.UserService;

@RestController
@RequestMapping("/hos/user")
public class UserController {

	@Autowired
	private UserService userService;
	 


    /**
     * 登录判断
     */
    @PostMapping("/login")
    public GlobalResponse<TUser> login( @RequestBody TUser tuser) {
    	String account = tuser.getAccount();
    	
    	String password = tuser.getPassword();
    	
    	String flag = userService.login(account, password);
    	if(flag =="success"){
    		  return new GlobalResponse<TUser>(1, "登录成功");
    	}else{
    	    return new GlobalResponse<TUser>(0, "登录失败");
    	}
    
    }


}
