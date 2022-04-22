package com.z.starter.autoconfig.controller;


import cn.hutool.db.Entity;
import com.z.starter.autoconfig.model.Page;
import com.z.starter.autoconfig.service.DataBaseService;
import com.z.starter.autoconfig.service.PageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@RestController()
@RequestMapping("/test")
public class TestController {


    @Resource
    PageService pageService;

    @Resource
    DataBaseService dataBaseService;

    @GetMapping("/page")
    public String testPage(){
        Page page = pageService.getPageInfo();
        return String.valueOf(page);
    }

    @GetMapping("/db")
    public String db() throws SQLException {
        List<Entity> list = dataBaseService.query();
        return String.valueOf(list);
    }
}
