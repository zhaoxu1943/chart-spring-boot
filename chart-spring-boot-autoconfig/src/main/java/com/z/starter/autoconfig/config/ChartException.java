package com.z.starter.autoconfig.config;

/**
 *
 * ChartException
 *
 * @author zhaoxu
 * @date 2022/4/24 14:01
 * @since
 */
public class ChartException extends RuntimeException {

    public ChartException() {
    }

    public ChartException(String message) {
        super(message);
    }

    public ChartException(String message, Throwable cause) {
        super(message, cause);
    }
}
