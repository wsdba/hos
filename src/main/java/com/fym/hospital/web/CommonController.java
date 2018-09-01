package com.fym.hospital.web;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fym.utils.QRCodeUtils;

@Controller
@RequestMapping("/")
public class CommonController {
	
	
	@RequestMapping("/index")
	public String add(String a){
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
	   
    @GetMapping("/createQrCode")
    public void createQrCode( HttpServletResponse response ,@RequestParam(name="id") String id) throws IOException {
    	   ImageIO.write(QRCodeUtils.Creat(id, null, 10), "png", response.getOutputStream());
    	
    }
}
