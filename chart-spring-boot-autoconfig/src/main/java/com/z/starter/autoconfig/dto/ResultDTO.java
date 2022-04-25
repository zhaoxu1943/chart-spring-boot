package com.z.starter.autoconfig.dto;

import cn.hutool.json.JSONUtil;
import com.z.starter.autoconfig.config.ResultCode;

import java.io.Serializable;

/**
 * @author zhaoxu
 * @date 2022/4/24 14:22
 * @since
 */
public class ResultDTO<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public ResultDTO() {
        super();
    }

    public ResultDTO setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResultDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultDTO setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
