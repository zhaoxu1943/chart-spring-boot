package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.config.ResultGenerator;
import com.z.starter.autoconfig.model.dto.PageCardDTO;
import com.z.starter.autoconfig.model.dto.ResultDTO;
import com.z.starter.autoconfig.model.po.Page;
import com.z.starter.autoconfig.service.PageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

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
    @GetMapping("/pageName/{pageName}")
    public Page getPageInfo(@PathVariable String pageName){
        return null;

    }


    /**
     * create page by pageCard DTO
     *
     * @param pageCardDTO
     * @return Page
     * @author zhaoxu
     */
    @PostMapping("/create")
    public ResultDTO<Page> createPage(@RequestBody PageCardDTO pageCardDTO) throws SQLException {
        return  ResultGenerator.genSuccessResult(pageService.createPage(pageCardDTO));
    }


}
