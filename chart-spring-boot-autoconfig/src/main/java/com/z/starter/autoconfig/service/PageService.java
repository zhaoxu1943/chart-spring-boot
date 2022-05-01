package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.dto.PageCardQuery;
import com.z.starter.autoconfig.po.Page;

public interface PageService {

  Page createPage(PageCardQuery pageCardQuery);
  Page getPageInfo(String pageName);
}