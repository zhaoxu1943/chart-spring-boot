package com.z.starter.autoconfig.service;

import com.z.starter.autoconfig.po.JudgeWhiteList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JudgeWhiteListService {
    /**
     * 创建白名单
     * @return
     */
    JudgeWhiteList createJudgeWhiteList(JudgeWhiteList judgeWhiteList);

    /**
     * 更新白名单
     * @return
     */
    JudgeWhiteList saveJudgeWhiteList(JudgeWhiteList judgeWhiteList);

    /**
     * 删除白名单
     * @param id 白名单ID
     * @return
     */
    JudgeWhiteList deleteJudgeWhiteList(String id);
    /**
     * 查询白名单列表列表.
     *
     * @return {@link JudgeWhiteList}
     */
    List<JudgeWhiteList> loadAllJudgeWhiteList();

    boolean isWhiteList(String sourceIp, String destinationIp, String alarmEventName);

    Page<JudgeWhiteList> findByQuery(String sourceIp, String destinationIp, String alarmEventName, Integer validStatus , int page, int pageSize);

}
