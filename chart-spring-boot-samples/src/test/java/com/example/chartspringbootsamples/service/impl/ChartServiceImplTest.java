package com.example.chartspringbootsamples.service.impl;

import com.example.chartspringbootsamples.base.BaseTest;
import com.example.chartspringbootsamples.util.MockUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.ChartQuery;
import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.service.ChartService;
import com.z.starter.autoconfig.service.PageService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
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
        Page pageSaved = pageService.createPage(testQuery2);
        cardId = pageSaved.getCards().get(0).getId();
        System.out.println(pageSaved);
    }

    @Test
    void createNormalTablesAndCreateBarsAndQuery() {

        //create

        //create normal tables for card_0

        Card card_0 = createNormalTablesForCard();

        //create bars for card_0

        createBarsForCard();

        //create normal charts

        createNormalChartsForCard();


        //query


        // get id list

        List<Long> barIdList = card_0.getBars().stream().map(BaseEntity::getId).collect(Collectors.toList());

        List<Long> normalTableIdList = card_0.getNormalTables().stream().map(BaseEntity::getId).collect(Collectors.toList());

        List<Long> normalChartIdList = card_0.getNormalCharts().stream().map(BaseEntity::getId).collect(Collectors.toList());


        //query map for bar
        Map<String, Object> queryMap = Maps.newHashMap();
        queryMap.put("key5", "value5");
        queryMap.put("key6", "value6");
        ChartQuery chartQuery = new ChartQuery().setChartType(ChartType.BAR).setId(barIdList.get(0)).setQueryMap(queryMap);

        //query map for normal table
        Map<String, Object> queryMap1 = Maps.newHashMap();
        queryMap1.put("key1", "value1");
        queryMap1.put("key2", "value2");
        ChartQuery chartQuery1 = new ChartQuery().setChartType(ChartType.NORMAL_TABLE).setId(normalTableIdList.get(0)).setQueryMap(queryMap1);

        //query map for normal chart
        Map<String, Object> queryMap2 = Maps.newHashMap();
        queryMap2.put("key11", "value11");
        queryMap2.put("key22", "value22");
        ChartQuery chartQuery2 = new ChartQuery().setChartType(ChartType.NORMAL_CHART).setId(normalChartIdList.get(0)).setQueryMap(queryMap2);

        // create query list
        List<ChartQuery> chartQueryList = Lists.newArrayList();
        chartQueryList.add(chartQuery);
        chartQueryList.add(chartQuery1);
        chartQueryList.add(chartQuery2);


        List<Chart> charts = chartService.getChartConfigDataByChartQuery(chartQueryList);
        assertThat(charts).isNotNull();
        assertThat(charts.size()).isEqualTo(3);
        System.out.println(charts);
    }

    private void createNormalChartsForCard() {

        List<NormalChart> normalChartList = Lists.newArrayList();

        NormalChart normalChart1 = new NormalChart();
        normalChart1.setTitle("normal_chart_test_user");
        normalChart1.setBeanName("testNormalChart1");
        normalChart1.setType(ChartType.NORMAL_CHART);


        normalChartList.add(normalChart1);

        NormalChart normalChart2 = new NormalChart();
        normalChart2.setTitle("normal_chart_test_user");
        normalChart2.setBeanName("testNormalChart1");
        normalChart2.setType(ChartType.NORMAL_CHART);


        normalChartList.add(normalChart2);

        chartService.createNormalChartsForCardByCardId(cardId, normalChartList);

    }

    private Card createNormalTablesForCard() {
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

        return chartService.createNormalTablesForCardByCardId(cardId, normalTableList);
    }

    private Card createBarsForCard() {
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


        Card card2 = chartService.createBarsForCardByCardId(cardId, barList);
        return card2;
    }

    @Test
    public void query_map_trans() {
        ChartQuery chartQuery = new ChartQuery();

        MockUtil.MockChartQuery(chartQuery);

        int[] testArr = (int[]) chartQuery.getQueryMap().get("test_arr");
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, testArr);

        MockUtil.QueryTest map = (MockUtil.QueryTest) chartQuery.getQueryMap().get("test_obj");
        Assertions.assertEquals("test_name", map.getName());
        Assertions.assertLinesMatch(Lists.newArrayList("test_list_1", "test_list_2"), map.getList());
    }

}