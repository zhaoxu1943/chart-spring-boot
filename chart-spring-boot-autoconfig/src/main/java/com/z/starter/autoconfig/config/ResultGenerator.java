package com.z.starter.autoconfig.config;

import com.z.starter.autoconfig.dto.ResultDTO;

/**
 * 响应结果生成工具
 * @author zhaoxu
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResultDTO genSuccessResult() {
        return new ResultDTO()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 封装结果,添加code与message
     * @author zhaoxu
     * @param
     * @throws
     */
    public static <T> ResultDTO<T> genSuccessResult(T data) {
        return new ResultDTO()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResultDTO genFailResult(String message) {
        return new ResultDTO()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
