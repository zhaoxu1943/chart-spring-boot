package com.z.starter.autoconfig.service.impl;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Page;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.PageRepository;
import com.z.starter.autoconfig.service.PageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {


    @Resource
    PageRepository pageRepository;

    @Resource
    CardRepository cardRepository;


    @Override
    @Transactional
    public Page createPage(PageCardQuery pageCardQuery)  {
        if (pageCardQuery ==null){
            throw new ChartException("PageCardDTO is null Object,cant create page");
        }
        //create Card
        Integer cardNumber = pageCardQuery.getCardNumber();
        List<Card> cardList = Lists.newArrayListWithCapacity(cardNumber);
        if (cardNumber!=null&&cardNumber>0){
            Integer cardSpan = pageCardQuery.getCardSpan();
            Integer cardOffset = pageCardQuery.getCardOffset();
            if (cardSpan!=null&&cardOffset!=null&&cardSpan>0&&cardOffset>=0){
                for (int i = 0; i < cardNumber; i++) {
                    cardList.add(new Card().setSpan(cardSpan).setCardOffset(cardOffset));
                    cardRepository.saveAll(cardList);
                }
            }
            String pageName = pageCardQuery.getPageName();
            if(StrUtil.isNotBlank(pageName)){
                Page page = new Page().setName(pageName).setCards(cardList);
                pageRepository.save(page);
                return page;
            }
        }
            throw new ChartException("IllegalArgument in PageCardDTO");
    }

    @Override
    public Page getPageInfo(String pageName) {
        Page page = pageRepository.findByName(pageName);
        List<Card> cardList= page.getCards();
        cardList.forEach(card -> {
            List<Chart> chartList = Lists.newArrayList();
            chartList.addAll(card.getBars());
            chartList.addAll(card.getNormalTables());
            card.setCharts(chartList);
            card.setNormalTables(null);
            card.setBars(null);
        });
        return page;
    }
}
