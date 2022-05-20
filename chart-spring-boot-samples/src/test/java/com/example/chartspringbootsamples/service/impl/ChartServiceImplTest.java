package com.example.chartspringbootsamples.service.impl;

import com.example.chartspringbootsamples.base.BaseTest;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.ChartQuery;
import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.service.ChartService;
import com.z.starter.autoconfig.service.PageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChartServiceImplTest extends BaseTest {



    private static final String TEST_PAGE_NAME_2 = "alarm2";

    private static final PageCardQuery testQuery2 = new PageCardQuery().setPageName(TEST_PAGE_NAME_2).setCardNumber(6).setCardOffset(1).setCardSpan(8).setNumberOfCutPage(2);


    @Autowired
    private ChartService chartService;
    @Autowired
    private PageService pageService;

    private Long cardId;

    @BeforeEach
    void createPageAndCardForTest() {
        Page pageSaved  = pageService.createPage(testQuery2);
        cardId = pageSaved.getCards().get(0).getId();
        System.out.println(pageSaved);
    }

    @Test
    void createNormalTablesAndCreateBarsAndQuery() {

        List<NormalTable> normalTableList = Lists.newArrayList();

        NormalTable normalTable = new NormalTable();
        normalTable.setTitle("normalTableTest_user");
        normalTable.setBeanName("testNormal1");
        normalTable.setType(ChartType.NORMAL_TABLE);

        NormalTableColumn name = new NormalTableColumn().setColumnKey("name").setColumnChineseName("姓名");
        NormalTableColumn age = new NormalTableColumn().setColumnKey("age").setColumnChineseName("年龄");
        List<NormalTableColumn> columnList = new ArrayList<>();

        columnList.add(name);
        columnList.add(age);
        normalTable.setNormalTableColumnList(columnList);
        normalTableList.add(normalTable);



        NormalTable normalTable2 = new NormalTable();
        normalTable2.setTitle("normalTableTest_good");
        normalTable2.setBeanName("testNormal1");
        normalTable2.setType(ChartType.NORMAL_TABLE);

        NormalTableColumn price = new NormalTableColumn().setColumnKey("price").setColumnChineseName("价格");
        NormalTableColumn good = new NormalTableColumn().setColumnKey("good").setColumnChineseName("商品");

        List<NormalTableColumn> columnList2 = new ArrayList<>();

        columnList2.add(price);
        columnList2.add(good);
        normalTable2.setNormalTableColumnList(columnList2);
        normalTableList.add(normalTable2);

        Card card1 = chartService.createNormalTablesForCardByCardId(cardId,normalTableList);


        List<Bar> barList = Lists.newArrayList();

        Bar bar = new Bar();
        bar.setTitle("bar_test_user");
        bar.setBeanName("testBar1");
        bar.setType(ChartType.BAR);
        bar.setXAxisName("user_x").setYAxisName("user_y");

        barList.add(bar);

        Bar bar2 = new Bar();
        bar2.setTitle("bar_test_good");
        bar2.setBeanName("testBar1");
        bar2.setType(ChartType.BAR);
        bar2.setXAxisName("good_x").setYAxisName("good_y");

        barList.add(bar2);


        Card card2 = chartService.createBarsForCardByCardId(cardId,barList);


        List<Long> barIdList = card2.getBars().stream().filter(card->card.getType().equals(ChartType.BAR)).map(BaseEntity::getId).collect(Collectors.toList());

        List<Long> normalTableIdList = card2.getNormalTables().stream().filter(card->card.getType().equals(ChartType.NORMAL_TABLE)).map(BaseEntity::getId).collect(Collectors.toList());


        //query
        Map<String,String> queryMap = Maps.newHashMap();
        queryMap.put("key5","value5");
        queryMap.put("key6","value6");

        ChartQuery chartQuery = new ChartQuery().setChartType(ChartType.BAR).setId(barIdList.get(0)).setQueryMap(queryMap);

        Map<String,String> queryMap1 = Maps.newHashMap();
        queryMap1.put("key1","value1");
        queryMap1.put("key2","value2");

        ChartQuery chartQuery1 = new ChartQuery().setChartType(ChartType.NORMAL_TABLE).setId(normalTableIdList.get(0)).setQueryMap(queryMap1);

        List<ChartQuery> chartQueryList = Lists.newArrayList();

        chartQueryList.add(chartQuery);
        chartQueryList.add(chartQuery1);

        List<Chart> charts = chartService.getChartConfigDataByChartQuery(chartQueryList);

        assertThat(charts).isNotNull();
        assertThat(charts.size()).isEqualTo(2);
        System.out.println(charts);
    }


}