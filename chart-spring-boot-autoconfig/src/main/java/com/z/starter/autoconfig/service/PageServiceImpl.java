package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.ChartProperties;
import com.z.starter.autoconfig.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


public class PageServiceImpl implements PageService {


    private final ChartProperties chartProperties;

    //construct inject
    public PageServiceImpl(ChartProperties chartProperties) {
        this.chartProperties = chartProperties;
    }


    @Override
    public Page getPageInfo() {
        Page page = new Page();
        page.setId(chartProperties.getPageId());
        return page;
    }
}
