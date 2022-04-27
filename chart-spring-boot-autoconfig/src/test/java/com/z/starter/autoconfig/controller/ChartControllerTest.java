package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.base.BaseUnitTest;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.po.ChartType;
import com.z.starter.autoconfig.service.ChartService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * @author zhaoxu
 * @date 2022/4/27 17:06
 * @since
 */
public class ChartControllerTest extends BaseUnitTest {


    @Resource
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ChartService chartService;

    @Test
    void createChartsForCardByCardId() {
        Long cardId = 1L;
        List<Chart> cardList = new ArrayList<>();
        cardList.add(new Chart().setType(ChartType.BAR));
        cardList.add(new Chart().setType(ChartType.PIE));

        given(this.chartService.createChartsForCardByCardId(cardId,cardList))
                .willReturn(new Card());

        // Requset



      }

    @Test
    void getChartConfigDataByChartId() {
      }


}