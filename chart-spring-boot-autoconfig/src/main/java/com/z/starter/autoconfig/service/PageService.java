package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.model.dto.PageCardDTO;
import com.z.starter.autoconfig.model.dto.ResultDTO;
import com.z.starter.autoconfig.model.po.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

public interface PageService {



    Page createPage(PageCardDTO pageCardDTO) throws SQLException;


    Page getPageInfo(String pageName) throws SQLException;
}