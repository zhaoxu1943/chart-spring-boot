package com.z.starter.autoconfig.config;

/**
 * 响应码枚举，参考HTTP状态码的语义
 * @author zhaoxu
 */
public enum ResultCode {


    SUCCESS(200),

    FAIL(400),

    UNAUTHORIZED(401),

    NOT_FOUND(404),

    INTERNAL_SERVER_ERROR(500);

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }
}
