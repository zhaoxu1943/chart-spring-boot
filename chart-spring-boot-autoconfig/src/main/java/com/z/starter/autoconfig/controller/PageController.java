package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.model.Card;
import com.z.starter.autoconfig.model.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxu
 * @date 2022/4/22 16:40
 * @since
 */
@RestController
@RequestMapping("/page-info")
public class PageController {



    @GetMapping("/pageName/{pageName}")
    public Page getPageInfo(@PathVariable String pageName){
        return null;

    }


}
