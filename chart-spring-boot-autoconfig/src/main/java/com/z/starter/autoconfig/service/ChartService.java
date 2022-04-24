package com.z.starter.autoconfig.service;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 14:06
 * @since
 */
public interface ChartService {

    List<Entity> query() throws SQLException;

}
