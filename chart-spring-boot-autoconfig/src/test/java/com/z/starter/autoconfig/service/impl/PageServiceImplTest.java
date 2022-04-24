package com.z.starter.autoconfig.service.impl;

import cn.hutool.db.Entity;
import cn.hutool.db.Session;
import cn.hutool.db.ds.DataSourceWrapper;
import com.z.starter.autoconfig.model.dto.PageCardDTO;
import com.z.starter.autoconfig.model.po.Page;
import com.z.starter.autoconfig.util.PageCreateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhaoxu
 * @date 2022/4/24 16:06
 * @since
 */
class PageServiceImplTest {

  @Test
  void createPage() throws SQLException {
    Session session = Session.create();
    //start tx
    session.beginTransaction();
    Page page = PageCreateUtil.createPageStructure(new PageCardDTO("alarm",8,9,1));
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