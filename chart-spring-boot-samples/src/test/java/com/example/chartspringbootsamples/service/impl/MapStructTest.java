package com.example.chartspringbootsamples.service.impl;

import com.z.starter.autoconfig.po.Bar;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.NormalTable;
import com.z.starter.autoconfig.util.VOMapUtil;
import com.z.starter.autoconfig.vo.CardVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


class MapStructTest {


    @Test
    void testMap(){
        Bar bar = new Bar();
        bar.setTitle("bar");

        NormalTable normalTable = new NormalTable();
        normalTable.setTitle("nor");
        Card card = new Card().setBars(Arrays.asList(bar))
                .setNormalTables(Arrays.asList(normalTable))
                .setTitle("123")
                .setCardOrder(1);


        CardVO  cardVO = VOMapUtil.cardToCardVO(card);
        Assertions.assertEquals(card.getBars().size()+card.getNormalTables().size(),cardVO.getCharts().size());
    }
}
