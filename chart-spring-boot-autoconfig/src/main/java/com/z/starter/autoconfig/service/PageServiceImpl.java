package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.ChartProperties;
import com.z.starter.autoconfig.model.Page;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


public class PageServiceImpl implements PageService {


    @Resource
    private ChartProperties chartProperties;


    @Override
    public Page getPageInfo() {
        Page page = new Page();
        page.setId(chartProperties.getPageId());
        return new Page();
    }
}
