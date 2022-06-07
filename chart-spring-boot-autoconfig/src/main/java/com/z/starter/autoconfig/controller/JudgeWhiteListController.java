package com.z.starter.autoconfig.controller;

import com.z.starter.autoconfig.po.JudgeWhiteList;
import com.z.starter.autoconfig.service.JudgeWhiteListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/white-judge")
@Tag(name = "Judge White　List rest api")
public class JudgeWhiteListController {
    @Resource
    JudgeWhiteListService judgeWhiteListService;

    @Operation(summary = "create Judge White　List")
    @PostMapping("/create")
    public JudgeWhiteList createJudgeWhiteList(@RequestBody JudgeWhiteList judgeWhiteList) {
        return judgeWhiteListService.saveJudgeWhiteList(judgeWhiteList);

    }

    @Operation(summary = "delete Judge White　List BY IDs")
    @GetMapping( "/delete")
    public JudgeWhiteList deleteJudgeWhiteList(@RequestParam(required = true) String ids) {
        return judgeWhiteListService.deleteJudgeWhiteList(ids);

    }

    @Operation(summary = "verify Judge White　List BY IDs")
    @GetMapping("/verify")
    public boolean isJudgeWhiteList(@RequestParam(required = true) String sourceIp,
                                    @RequestParam(required = false) String destinationIp,
                                    @RequestParam(required = true) String alarmEventName) {
        return judgeWhiteListService.isWhiteList(sourceIp, destinationIp, alarmEventName);
    }

    @Operation(summary = "load All Judge White　List BY IDs")
    @GetMapping("/loadAll")
    public List<JudgeWhiteList> loadAllJudgeWhiteList() {
        return judgeWhiteListService.loadAllJudgeWhiteList();

    }


    @Operation(summary = "select  Judge White　List BY IDs")
    @GetMapping("/select")
    public Page<JudgeWhiteList> loadAllJudgeWhiteList(@RequestParam(required = false) String sourceIp,
                                                      @RequestParam(required = false)String destinationIp,
                                                      @RequestParam(required = false)String alarmEventName,
                                                      @RequestParam(required = false) Integer validStatus,
                                                      @RequestParam(required = true)int page,
                                                      @RequestParam(required = true)int pageSize) {
        return judgeWhiteListService.findByQuery(sourceIp, destinationIp, alarmEventName, validStatus, page, pageSize);

    }

}
