package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.config.ResultGenerator;
import com.z.starter.autoconfig.dto.ResultDTO;
import com.z.starter.autoconfig.po.Card;
import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.service.ChartService;
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
public class ChartController {

    @Resource
    ChartService chartService;

    @PostMapping("/create-charts-for-card-by-card-id/card-id/{cardId}")
    public ResultDTO<Card> createChartsForCardByCardId(@PathVariable Long cardId , @RequestBody List<Chart> chartList){
            return ResultGenerator.genSuccessResult( chartService.createChartsForCardByCardId(cardId,chartList));

    }


}
