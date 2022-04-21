package com.example.chartspringbootsamples.controller;


import com.z.starter.autoconfig.service.PageService;
import com.z.starter.autoconfig.service.PageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("test")
public class TestController {


    @Resource
    PageService pageService;

    @GetMapping("page")
    public Integer testPage(){
        return pageService.getPageInfo().getId();
    }
}
