package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.config.ResultGenerator;
import com.z.starter.autoconfig.dto.ChartQuery;
import com.z.starter.autoconfig.dto.ResultDTO;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
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

    @Operation(summary = "create charts for card by card id")
    @PostMapping("/create-charts-for-card-by-card-id/card-id/{cardId}")
    public ResultDTO<Card> createChartsForCardByCardId(@PathVariable Long cardId , @RequestBody List<Chart> chartList){
            return ResultGenerator.genSuccessResult(chartService.createChartsForCardByCardId(cardId,chartList));

    }

    @Operation(summary = "get chart config data by ChartQuery obj ")
    @PostMapping("/get-chart-config-data")
    public ResultDTO<List<Chart>> getChartConfigDataByChartQuery(@RequestBody List<ChartQuery> chartQueryList){
        List<Chart> chartList = chartService.getChartConfigDataByChartQuery(chartQueryList);
        return ResultGenerator.genSuccessResult(chartList);

    }
}
