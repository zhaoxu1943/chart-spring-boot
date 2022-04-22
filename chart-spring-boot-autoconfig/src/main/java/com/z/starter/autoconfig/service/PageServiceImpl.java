package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.ChartProperties;
import com.z.starter.autoconfig.model.Page;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService {


    private final ChartProperties chartProperties;


    //construct inject
    public PageServiceImpl(ChartProperties chartProperties) {
        this.chartProperties = chartProperties;
    }


    @Override
    public Page getPageInfo() {
        Page page = new Page();
        page.setPageId(chartProperties.getPageId());
        return page;
    }
}
