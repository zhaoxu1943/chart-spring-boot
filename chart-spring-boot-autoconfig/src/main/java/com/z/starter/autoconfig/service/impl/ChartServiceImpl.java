package com.z.starter.autoconfig.service.impl;


import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.core.BaseData;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.query.ChartQuery;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.ChartRepository;
import com.z.starter.autoconfig.service.ChartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author zhaoxu
 * @date 2022/4/22 14:07
 * @since
 */
@Service
public class ChartServiceImpl implements ChartService, ApplicationContextAware {

    @Resource
    CardRepository cardRepository;
    @Resource
    ChartRepository chartRepository;

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
         this.ctx = ctx;
    }

    @Override
    @Transactional
    public Card createChartsForCardByCardId(Long cardId, List<Chart> chartList) {
        Optional<Card> cardOption = cardRepository.findById(cardId);
        if (cardOption.isPresent()){
            Card card = cardOption.get();
            card.setCharts(chartList);
            cardRepository.save(card);
            return card;
        }
        throw new ChartException("create charts for card failed Exception");
    }


    @Override
    public  List<Chart> getChartConfigDataByChartQuery(List<ChartQuery> chartQueryList) {
        List<Chart> chartList = Lists.newArrayList();
        for (ChartQuery chartQuery : chartQueryList) {
            Optional<Chart> chartOptional = chartRepository.findById(chartQuery.getId());
            if (chartOptional.isPresent()){
                Chart chart =  chartOptional.get();
                dataInject(chart,chartQuery);
                chartList.add(chart);
            }
        }
        return chartList;

    }


    private <T extends BaseData> void dataInject(Chart<T> chart, ChartQuery chartQuery) {
            if (StringUtils.isNotBlank(chart.getBeanName())){
                //invoke constructor
                DataInject<T> inject = (DataInject<T>) ctx.getBean(chart.getBeanName(),chartQuery);
                chart.setData(inject.injectWithQuery(chartQuery));
            }
        }

}