package com.z.starter.autoconfig.service;

import cn.hutool.db.Entity;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 14:06
 * @since
 */
public interface ChartService {


    Card createChartsForCardByCardId(Long cardId, List<Chart> chartList);
}
