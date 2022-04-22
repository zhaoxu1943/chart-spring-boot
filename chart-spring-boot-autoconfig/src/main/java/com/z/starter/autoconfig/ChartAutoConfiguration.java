package com.z.starter.autoconfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:42
 * @since 0.0.1
 */
@Configuration
@EnableConfigurationProperties(ChartProperties.class)
@ComponentScan()
public class ChartAutoConfiguration {

}
