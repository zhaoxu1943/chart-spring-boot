package com.z.starter.autoconfig.service.impl;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.z.starter.autoconfig.service.ChartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 14:07
 * @since
 */
@Service
public class ChartServiceImpl implements ChartService {

    @Resource
    DataSource dataSource;

    @Override
    public List<Entity> query() throws SQLException {
        Db db = DbUtil.use(dataSource);
        List<Entity> list =db.query("select 1 from dual");
        System.out.println(list);
        return list;
    }



}
