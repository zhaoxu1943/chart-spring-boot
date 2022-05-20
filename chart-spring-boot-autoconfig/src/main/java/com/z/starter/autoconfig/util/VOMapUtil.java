package com.z.starter.autoconfig.util;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.vo.CardVO;
import com.z.starter.autoconfig.vo.PageVO;


import java.util.List;
import java.util.stream.Collectors;

public class VOMapUtil {

    public static PageVO pageToPageVO(Page page){
        if (page!=null) {
            PageVO pageVO = new PageVO();
            List<Card> cardList = page.getCards();
            List<CardVO> cardVOList =  cardList.stream().map(VOMapUtil::cardToCardVO).collect(Collectors.toList());
            pageVO.setCards(cardVOList);
            BeanUtil.copyProperties(page,pageVO, "cards");
            return pageVO;
        }
        throw new ChartException("Page is null");
    }


    public static CardVO cardToCardVO(Card card) {
        if (card!=null) {
            CardVO cardVO = new CardVO();
            List<Chart> chartList = Lists.newArrayList();
                List<Bar> bars =  card.getBars();
                List<NormalTable> normalTables = card.getNormalTables();
                if (bars!=null){
                    chartList.addAll(bars);
                }
                if (normalTables!=null){
                    //addAll throw NPE
                    //NullPointerException – if the specified collection contains one or more null elements and this list does not permit null elements, or if the specified collection is null
                    chartList.addAll(normalTables);
                }
                cardVO.setCharts(chartList);
                BeanUtil.copyProperties(card,cardVO,"bars","normalTables");
                return cardVO;
        }
        throw new ChartException("Card is null");
    }

}
