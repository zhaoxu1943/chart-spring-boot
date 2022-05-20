package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.po.Page;
import com.z.starter.autoconfig.vo.PageVO;

public interface PageService {


  Page createPage(PageCardQuery pageCardQuery);

  PageVO getPageInfo(String pageName);
}