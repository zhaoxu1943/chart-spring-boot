package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.model.po.Card;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 16:40
 * @since
 */
@RestController
@RequestMapping("/chart-info")
public class ChartController {


    @PostMapping("/list")
    public List<Card> getCardInfo(@RequestBody List<String> cardIdList){
        return null;
    }


}
