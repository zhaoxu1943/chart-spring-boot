package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.ChartQuery;

import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 14:06
 * @since
 */
public interface ChartService {


    List<Chart> getChartConfigDataByChartQuery(List<ChartQuery> chartQueryList);

    Card createNormalTablesForCardByCardId(Long cardId, List<NormalTable> normalTableList);

    Card createBarsForCardByCardId(Long cardId, List<Bar> barList);
}
