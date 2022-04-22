package com.example.chartspringbootsamples.controller;


import com.z.starter.autoconfig.model.Page;
import com.z.starter.autoconfig.service.PageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping("/test")
public class TestController {


    @Resource
    PageService pageService;

    @GetMapping("/page")
    public String testPage(){
        Page page = pageService.getPageInfo();
        return String.valueOf(page);
    }
}
