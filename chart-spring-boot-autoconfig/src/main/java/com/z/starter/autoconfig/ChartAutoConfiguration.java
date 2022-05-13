package com.z.starter.autoconfig;

import com.z.starter.autoconfig.config.ChartProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import javax.annotation.Resource;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:42
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(ChartProperties.class)
//IOC
@ComponentScan()
//JPA
@EntityScan("com.z.starter.autoconfig.po")
@EnableJpaRepositories("com.z.starter.autoconfig.repository")
public class ChartAutoConfiguration {

    @Resource
    ChartProperties chartProperties;

    @Bean(name = "chartStatus")
    public void getEnabled(){
        System.out.println(chartProperties.isEnabled());
    }





}
