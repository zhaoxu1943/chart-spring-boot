package com.z.starter.autoconfig.service.impl;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.ChartRepository;
import com.z.starter.autoconfig.service.ChartService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
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
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
         this.ctx = ctx;
    }

    @Override
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
    public List<Chart> getChartConfigDataByCardId(List<Long> chartIdList) {
            return chartRepository.findAllById(chartIdList);
    }

    @Override
    public void dataInject(List<Chart> chartList) {
        chartList.forEach(chart -> chart.setData(ctx.getBean(chart.getBeanName(), DataInject.class).inject()));
    }
}
