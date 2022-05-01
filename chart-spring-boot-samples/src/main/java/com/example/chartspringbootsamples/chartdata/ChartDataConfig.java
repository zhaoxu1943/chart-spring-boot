package com.example.chartspringbootsamples.chartdata;

import com.example.chartspringbootsamples.util.MockUtil;
import com.example.chartspringbootsamples.vo.XData;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.dto.ChartQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhaoxu
 * @date 2022/4/27 13:40
 * @since
 */
@Configuration
public class ChartDataConfig {

    @Bean(name = "testBean2")
    public DataInject<XData> testChartData1(){
        return (chartQuery -> {
            System.out.println(chartQuery);
            return MockUtil.getBaseDataMockMap();
        });
    }


    @Bean(name = "testBean3")
    public DataInject<XData> testChartData2(){
       return new DataInject<XData>() {
           @Override
           public XData injectWithQuery(ChartQuery chartQuery) {
               System.out.println(chartQuery);
               return MockUtil.getBaseDataMockMap();
           }
       };
    }

}
