package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.dto.ChartQuery;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 14:06
 * @since
 */
public interface ChartService {


    Card createChartsForCardByCardId(Long cardId, List<Chart> chartList);

    List<Chart> getChartConfigDataByChartQuery(List<ChartQuery> chartQueryList);
}
