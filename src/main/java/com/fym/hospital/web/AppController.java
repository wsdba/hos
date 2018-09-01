package com.fym.hospital.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fym.hos.dto.GlobalResponse;

/**
 * Created by Administrator on 2018/8/27.
 */
@RestController
@RequestMapping("/app")
public class AppController {

    /**
     * 用于app判断当前服务是否有效
     * @return
     */
    @CrossOrigin
    @RequestMapping("/index")
    public GlobalResponse<String> index() {
        return new GlobalResponse<String>(0, "请求成功");
    }
}
