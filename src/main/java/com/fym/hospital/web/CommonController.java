package com.fym.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fym.hos.service.QualityService;

@Controller
@RequestMapping("/hos/common")
public class CommonController {
	
	@Autowired
	private QualityService qualityService;
	
	@RequestMapping("/index")
	public String add(String a){
		System.out.println("welcome");
		return "admin/welcome";
	}
	@RequestMapping
    public String execute(){
        return "admin/admin";
    }
	
	
	@RequestMapping("/to")
	public String toPage(String page){
		return page;
	}
}
