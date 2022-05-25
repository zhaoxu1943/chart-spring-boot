package com.z.starter.autoconfig.service.impl;


import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.core.data.BaseData;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.ChartQuery;
import com.z.starter.autoconfig.repository.BarRepository;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.NormalChartRepository;
import com.z.starter.autoconfig.repository.NormalTableRepository;
import com.z.starter.autoconfig.service.ChartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Arrays;
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
    @Resource
    NormalChartRepository normalChartRepository;




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
        throw new ChartException("Cant find card by given cardId!");
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
        throw new ChartException("Cant find card by given cardId!");
    }


    @Override
    public Card createNormalChartsForCardByCardId(Long cardId, List<NormalChart> normalChartList) {
        Optional<Card> cardOption = cardRepository.findById(cardId);
        if (cardOption.isPresent()){
            Card card = cardOption.get();
            card.setNormalCharts(normalChartList);
            cardRepository.save(card);
            return card;
        }
        throw new ChartException("Cant find card by given cardId!");
    }

    @Override
    public  List<Chart> getChartConfigDataByChartQuery(List<ChartQuery> chartQueryList) {
        List<Chart> chartList = Lists.newArrayList();
        for (ChartQuery chartQuery : chartQueryList) {
            ChartType chartType = chartQuery.getChartType();
            if (ChartType.BAR.equals(chartType)){
                Optional<Bar> chartOptional = barRepository.findById(chartQuery.getId());
                if (chartOptional.isPresent()){
                    Bar chart =  chartOptional.get();
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
            }else if (ChartType.NORMAL_CHART.equals(chartType)){
                Optional<NormalChart> chartOptional = normalChartRepository.findById(chartQuery.getId());
                if (chartOptional.isPresent()){
                    Chart chart =  chartOptional.get();
                    dataInject(chart,chartQuery);
                    chartList.add(chart);
                }
            } else {
                throw new ChartException("Unsupported chart type!");
            }
        }
        return chartList;

    }


    private <T extends BaseData> void dataInject(Chart<T> chart, ChartQuery chartQuery) {
        String chartDataBeanName = chart.getBeanName();
        String[] beanNames = ctx.getBeanDefinitionNames();
        if (StringUtils.isNotBlank(chartDataBeanName)){
                if (Arrays.asList(beanNames).contains(chartDataBeanName)) {
                    DataInject<T> inject = (DataInject<T>) ctx.getBean(chart.getBeanName(),chartQuery);
                    chart.setData(inject.injectWithQuery(chartQuery));
                }else{
                    throw new ChartException("Cant find bean:beanName="+chartDataBeanName+" in ioc container!");
                }
            }else{
            throw new ChartException("chart:id="+chart.getId()+"beanName is empty");
        }
        }

}