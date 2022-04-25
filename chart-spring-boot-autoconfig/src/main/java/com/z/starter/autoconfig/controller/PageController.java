package com.z.starter.autoconfig.controller;

import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ResultGenerator;
import com.z.starter.autoconfig.dto.PageCardDTO;
import com.z.starter.autoconfig.dto.ResultDTO;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Page;
import com.z.starter.autoconfig.repository.PageRepository;
import com.z.starter.autoconfig.service.PageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 16:40
 * @since
 */
@RestController
@RequestMapping("/page-info")
public class PageController {


    @Resource
    PageService pageService;


    /**
     * query page info with the given page name
     * include cards info
     * @param pageName
     * @return Page
     * @author zhaoxu
     */
    @GetMapping("/page-name/{pageName}")
    public Page getPageInfo(@PathVariable String pageName){
        return pageService.getPageInfo(pageName);

    }


    /**
     * create page by pageCard DTO
     *
     * @param pageCardDTO
     * @return Page
     * @author zhaoxu
     */
    @PostMapping("/create")
    public ResultDTO<Page> createPage(@RequestBody PageCardDTO pageCardDTO){
        return  ResultGenerator.genSuccessResult(pageService.createPage(pageCardDTO));
    }


}
