package com.z.starter.autoconfig.config;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

/**
 * @author zhaoxu
 * @date 2022/4/24 14:22
 * @since
 */
public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public Result() {
        super();
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
