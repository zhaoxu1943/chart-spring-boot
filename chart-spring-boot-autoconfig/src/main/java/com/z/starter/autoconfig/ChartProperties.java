package com.z.starter.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhaoxu
 * @date 2022/4/21 15:53
 * @since
 */
@ConfigurationProperties(prefix = ChartProperties.CHART_PREFIX)
@Data
public class ChartProperties {

    public static final String CHART_PREFIX = "chart";

    /**
     * whether enable chart starter
     */
    private boolean enable = true;
}
