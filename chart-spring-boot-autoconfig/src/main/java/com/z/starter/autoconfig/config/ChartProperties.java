package com.z.starter.autoconfig.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * must add getter and setter
 * @author zhaoxu
 * @date 2022/4/21 15:53
 * @since
 */
@ConfigurationProperties(prefix = ChartProperties.CHART_PREFIX)
public class ChartProperties {

    public static final String CHART_PREFIX = "chart";

    public boolean isEnabled = true;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }
}
