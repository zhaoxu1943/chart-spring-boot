package com.z.starter.autoconfig.service.impl;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.ChartRepository;
import com.z.starter.autoconfig.service.ChartService;
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
public class ChartServiceImpl implements ChartService {

    @Resource
    ChartRepository chartRepository;
    @Resource
    CardRepository cardRepository;

    @Resource
    DataSource dataSource;

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
}
