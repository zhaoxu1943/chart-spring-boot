package com.z.starter.autoconfig.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig
 * @author zhaoxu
 */
@Configuration
public class ChartProjectConfig {


    @Bean
    public GroupedOpenApi chartGroup(){
        return GroupedOpenApi.builder()
                .group(ChartProperties.CHART_PREFIX)
                .pathsToMatch("/**/")
                .packagesToScan("com.z.starter.autoconfig")
                .build();
    }
}
