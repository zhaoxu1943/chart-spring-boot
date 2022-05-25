package com.example.chartspringbootsamples.chartdata;

import com.example.chartspringbootsamples.po.Person;
import com.example.chartspringbootsamples.util.MockUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.core.data.BarData;
import com.z.starter.autoconfig.core.data.NormalChartData;
import com.z.starter.autoconfig.core.data.NormalTableData;
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

    @Bean(name = "testNormal1")
    public DataInject<NormalTableData<Person>> testNormal1(){
        return (chartQuery -> {
            System.out.println(chartQuery);
            //mock db query start
            NormalTableData<Person> normalTableData = new NormalTableData<>();
            Person person1 = new Person().setName("张三").setAge(2);
            Person person2 = new Person().setName("李五").setAge(20);
            List<Person> personList = Lists.newArrayList();
            personList.add(person1);
            personList.add(person2);
            //mock db query stop
            normalTableData.setNormalTableObjectList(personList);
            return normalTableData;
        });
    }


    @Bean(name = "testBar1")
    public DataInject<BarData> testBar1(){
        return (chartQuery -> {
            System.out.println(chartQuery);
            return MockUtil.getBaseDataMockMap();
        });
    }


    @Bean(name = "testNormalChart1")
    public DataInject<NormalChartData> testNormalChart1(){
        return (chartQuery -> {
            NormalChartData normalChartData = new NormalChartData();
            System.out.println(chartQuery);
            Map<String,String> dataMap = Maps.newHashMap();
            dataMap.put("imaPath","/test/path");
            dataMap.put("labelKey","source");
            dataMap.put("labelName","设备来源");
            dataMap.put("labelValue","12");
            normalChartData.setDataMap(dataMap);
            return normalChartData;
        });
    }


}
