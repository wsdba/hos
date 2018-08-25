package com.fym.hospital.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping("/toJson")
	public String toPage(String page){
		return page;
	}
}
