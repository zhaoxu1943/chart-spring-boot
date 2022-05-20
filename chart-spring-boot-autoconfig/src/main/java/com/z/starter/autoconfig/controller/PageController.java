package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.po.Page;
import com.z.starter.autoconfig.service.PageService;
import com.z.starter.autoconfig.vo.PageVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * @return PageVO 供前端使用
     * @author zhaoxu
     */
    @Operation(summary = "get page info by page name")
    @GetMapping("/page-name/{pageName}")
    public PageVO getPageInfo(@PathVariable String pageName){
        return pageService.getPageInfo(pageName);

    }


    /**
     * create page by pageCard DTO
     *
     * @param pageCardQuery
     * @return Page
     * @author zhaoxu
     */
    @Operation(summary = "create page by pageCardDTO")
    @PostMapping("/create")
    public Page createPage(@RequestBody PageCardQuery pageCardQuery){
        return pageService.createPage(pageCardQuery);
    }


}
