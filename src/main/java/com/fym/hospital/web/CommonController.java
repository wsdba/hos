package com.fym.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fym.hos.service.QualityService;

@Controller
@RequestMapping("/")
public class CommonController {
	
	@Autowired
	private QualityService qualityService;
	
	@RequestMapping("/index")
	public String add(String a){
		return "admin/welcome";
	}
	@RequestMapping
    public String execute(){
        return "admin/login";
    }
	
	
	@RequestMapping("/to")
	public String toPage(String page){
		return page;
	}
	
}
