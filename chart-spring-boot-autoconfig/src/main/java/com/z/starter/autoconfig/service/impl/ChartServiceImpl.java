package com.z.starter.autoconfig.service.impl;


import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.core.data.BaseData;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.ChartQuery;
import com.z.starter.autoconfig.repository.BarRepository;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.NormalTableRepository;
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
    BarRepository barRepository;
    @Resource
    NormalTableRepository normalTableRepository;




    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
         this.ctx = ctx;
    }


    @Override
    public Card createNormalTablesForCardByCardId(Long cardId, List<NormalTable> normalTableList) {
        Optional<Card> cardOption = cardRepository.findById(cardId);
        if (cardOption.isPresent()){
            Card card = cardOption.get();
            card.setNormalTables(normalTableList);
            cardRepository.save(card);
            return card;
        }
        throw new ChartException("create charts for card failed Exception");
    }

    @Override
    public Card createBarsForCardByCardId(Long cardId, List<Bar> barList) {
        Optional<Card> cardOption = cardRepository.findById(cardId);
        if (cardOption.isPresent()){
            Card card = cardOption.get();
            card.setBars(barList);
            cardRepository.save(card);
            return card;
        }
        throw new ChartException("create charts for card failed Exception");
    }




    @Override
    public  List<Chart> getChartConfigDataByChartQuery(List<ChartQuery> chartQueryList) {
        List<Chart> chartList = Lists.newArrayList();
        for (ChartQuery chartQuery : chartQueryList) {
            ChartType chartType = chartQuery.getChartType();
            if (ChartType.BAR.equals(chartType)){
                Optional<Bar> chartOptional = barRepository.findById(chartQuery.getId());
                if (chartOptional.isPresent()){
                    Chart chart =  chartOptional.get();
                    dataInject(chart,chartQuery);
                    chartList.add(chart);
                }
            }else if (ChartType.NORMAL_TABLE.equals(chartType)){
                Optional<NormalTable> chartOptional = normalTableRepository.findById(chartQuery.getId());
                if (chartOptional.isPresent()){
                    Chart chart =  chartOptional.get();
                    dataInject(chart,chartQuery);
                    chartList.add(chart);
                }
            }else {
                throw new ChartException("传入不支持的图表类型");
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