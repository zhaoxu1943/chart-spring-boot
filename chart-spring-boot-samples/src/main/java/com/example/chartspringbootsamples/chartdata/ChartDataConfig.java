package com.example.chartspringbootsamples.chartdata;

import com.example.chartspringbootsamples.po.Person;
import com.example.chartspringbootsamples.util.MockUtil;
import com.example.chartspringbootsamples.vo.XData;
import com.google.common.collect.Lists;
import com.z.starter.autoconfig.core.BaseData;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.query.ChartQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * @author zhaoxu
 * @date 2022/4/27 13:40
 * @since
 */
@Configuration
public class ChartDataConfig {

    @Bean(name = "testBean5")
    public DataInject<BaseData<Person>> testChartData5(){
        return (chartQuery -> {
            System.out.println(chartQuery);
            //mock db query start
            BaseData<Person> baseData = new BaseData<>();
            Person person1 = new Person().setName("张三").setAge(2);
            Person person2 = new Person().setName("李五").setAge(20);
            List<Person> personList = Lists.newArrayList();
            personList.add(person1);
            personList.add(person2);
            //mock db query stop
            baseData.setNormalTableObjectList(personList);
            return baseData;
        });
    }


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
