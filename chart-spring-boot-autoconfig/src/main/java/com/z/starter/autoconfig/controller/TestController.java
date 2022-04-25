package com.z.starter.autoconfig.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * for test starter rest api
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
@RestController()
@RequestMapping("/test")
public class TestController {






    @GetMapping("/test")
    public String testPage(){
        return "hello,starter!";
    }


}
