package com.example.chartspringbootsamples.chartdata;

import com.example.chartspringbootsamples.util.MockUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.dto.XYDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 * @date 2022/4/27 13:40
 * @since
 */
@Configuration
public class ChartDataConfig {

    @Bean(name = "testBean2")
    public DataInject testChartData(){
        return MockUtil::getMockMap;
    }


}
