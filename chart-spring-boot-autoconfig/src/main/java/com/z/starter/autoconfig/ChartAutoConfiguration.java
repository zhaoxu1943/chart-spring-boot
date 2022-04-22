package com.z.starter.autoconfig;

import com.z.starter.autoconfig.service.PageService;
import com.z.starter.autoconfig.service.PageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:42
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(ChartProperties.class)
public class ChartAutoConfiguration {

    private final ChartProperties chartProperties;

    public ChartAutoConfiguration(ChartProperties chartProperties) {
        this.chartProperties = chartProperties;
    }


        @Bean
        public PageService pageService(){
            return new PageServiceImpl(chartProperties);
        }
}
