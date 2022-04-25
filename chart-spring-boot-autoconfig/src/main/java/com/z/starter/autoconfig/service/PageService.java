package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.dto.PageCardDTO;
import com.z.starter.autoconfig.po.Page;

import java.sql.SQLException;

public interface PageService {


  Page createPage(PageCardDTO pageCardDTO);
  Page getPageInfo(String pageName);
}