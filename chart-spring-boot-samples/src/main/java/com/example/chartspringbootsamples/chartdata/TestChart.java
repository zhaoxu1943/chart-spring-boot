package com.example.chartspringbootsamples.chartdata;

import com.example.chartspringbootsamples.util.MockUtil;
import com.example.chartspringbootsamples.vo.XData;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.query.ChartQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author zhaoxu
 * @date 2022/4/27 11:09
 * @since
 */
@Component(value = "testBean")
@Scope(scopeName=SCOPE_PROTOTYPE)
public class TestChart implements DataInject<XData> {


    @Override
    public XData injectWithQuery(ChartQuery chartQuery) {
        System.out.println(chartQuery);
        return MockUtil.getBaseDataMockMap();
    }
}
