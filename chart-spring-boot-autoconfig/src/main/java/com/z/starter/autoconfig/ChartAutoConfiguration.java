package com.z.starter.autoconfig;

import com.z.starter.autoconfig.service.PageService;
import com.z.starter.autoconfig.service.PageServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:42
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(ChartProperties.class)
public class ChartAutoConfiguration {


        @Bean
        public PageService pageService(){
            return new PageServiceImpl();
        }
}
