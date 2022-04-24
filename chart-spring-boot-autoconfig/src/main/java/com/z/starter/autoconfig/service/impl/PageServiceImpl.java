package com.z.starter.autoconfig.service.impl;

import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.lang.func.VoidFunc1;
import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.Session;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.config.ChartProperties;
import com.z.starter.autoconfig.model.dto.PageCardDTO;
import com.z.starter.autoconfig.model.dto.XYDTO;
import com.z.starter.autoconfig.model.po.Page;
import com.z.starter.autoconfig.service.PageService;
import com.z.starter.autoconfig.util.PageCreateUtil;
import net.bytebuddy.ByteBuddy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PageServiceImpl implements PageService {



    @Resource
    DataSource dataSource;


    @Override
    public Page createPage(PageCardDTO pageCardDTO) throws SQLException {
        Page page = PageCreateUtil.createPageStructure(pageCardDTO);
        savePageStructure(page);
        return page;
    }


    @Override
    public Page getPageInfo(String pageName) throws SQLException {


       //dynamic
        Map<String, XYDTO> demensionMap = Maps.newHashMap();


        return null;


    }

    private void savePageStructure(Page page) throws SQLException {
        try(Session session = DbUtil.newSession(dataSource)){
            //start tx
            session.beginTransaction();
            Entity pageEntity = Entity.parse(page,true,true);
            pageEntity.remove("card_list");
            session.insert(pageEntity);
            page.getCardList().forEach(card -> {
                try {
                    session.insert(Entity.parse(card,true,true));
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            });
            session.commit();
        }

    }
}
