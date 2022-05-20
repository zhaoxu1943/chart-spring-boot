package com.example.chartspringbootsamples.service.impl;

import com.example.chartspringbootsamples.base.BaseTest;
import com.z.starter.autoconfig.po.Page;
import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.service.PageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * page 单元测试
 * @author zhaoxu
 */
class PageServiceImplTest extends BaseTest {

    @Autowired
    private PageService pageService;


    private static final String TEST_PAGE_NAME_3 = "alarm3";

    private static final PageCardQuery testQuery3 = new PageCardQuery().setPageName(TEST_PAGE_NAME_3).setCardNumber(6).setCardOffset(1).setCardSpan(8).setNumberOfCutPage(2);


    @Test
    void createAndGetPage() {
        Page pageSaved  = pageService.createPage(testQuery3);
        assertThat(pageSaved).isNotNull();
        assertEquals(pageSaved.getName(),TEST_PAGE_NAME_3);

        Page pageQuery  = pageService.getPageInfo(TEST_PAGE_NAME_3);
        assertThat(pageQuery).isNotNull();
        assertEquals(pageQuery.getName(),TEST_PAGE_NAME_3);
    }

}