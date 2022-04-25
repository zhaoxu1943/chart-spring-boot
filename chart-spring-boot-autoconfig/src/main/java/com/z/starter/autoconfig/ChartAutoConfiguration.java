package com.z.starter.autoconfig;

import com.z.starter.autoconfig.config.ChartProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
@EntityScan()
@EnableJpaRepositories
public class ChartAutoConfiguration {

}
