package com.z.starter.autoconfig.service.impl;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.repository.ChartRepository;
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
    ChartRepository chartRepository;


    @Override
    public void createChartsForCardByCardId(Long cardId, List<Chart> chartList) {


    }
}
