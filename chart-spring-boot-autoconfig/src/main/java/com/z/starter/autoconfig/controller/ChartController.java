package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.config.ResultGenerator;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.ChartQuery;
import com.z.starter.autoconfig.config.Result;
import com.z.starter.autoconfig.service.ChartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 16:40
 * @since
 */
@RestController
@RequestMapping("/chart-info")
@Tag(name = "chart config rest api")
public class ChartController {

    @Resource
    ChartService chartService;

    @Operation(summary = "create Bars For Card By CardId")
    @PostMapping("/create-bars-for-card-by-card-id/card-id/{cardId}")
    public Card createBarsForCardByCardId(@PathVariable Long cardId , @RequestBody List<Bar> barList){
            return chartService.createBarsForCardByCardId(cardId,barList);

    }


    @Operation(summary = "create Normal Tables For Card By CardId")
    @PostMapping("/create-normal-tables-for-card-by-card-id/card-id/{cardId}")
    public Card createNormalTablesForCardByCardId(@PathVariable Long cardId , @RequestBody List<NormalTable> normalTableList){
        return chartService.createNormalTablesForCardByCardId(cardId,normalTableList);

    }


    @Operation(summary = "create Normal Charts For Card By CardId")
    @PostMapping("/create-normal-charts-for-card-by-card-id/card-id/{cardId}")
    public Card createNormalChartsForCardByCardId(@PathVariable Long cardId , @RequestBody List<NormalChart> normalChartList){
        return chartService.createNormalChartsForCardByCardId(cardId,normalChartList);

    }


    @Operation(summary = "get chart config data by ChartQuery obj ")
    @PostMapping("/get-chart-config-data")
    public List<Chart> getChartConfigDataByChartQuery(@RequestBody List<ChartQuery> chartQueryList){
        return chartService.getChartConfigDataByChartQuery(chartQueryList);

    }
}
