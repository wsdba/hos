package com.fym.hospital.web;

import com.fym.hos.dto.GlobalResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/8/27.
 */
@RestController
@RequestMapping("/app")
public class AppController {

    /**
     * 用于app判断当前服务是否有效
     * @param a
     * @return
     */
    @RequestMapping("/index")
    public GlobalResponse<String> index() {
        return new GlobalResponse<String>(0, "请求成功");
    }
}
