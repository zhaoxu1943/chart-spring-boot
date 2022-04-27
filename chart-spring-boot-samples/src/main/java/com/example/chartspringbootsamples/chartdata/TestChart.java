package com.example.chartspringbootsamples.chartdata;

import com.example.chartspringbootsamples.util.MockUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.core.DataInject;
import com.z.starter.autoconfig.dto.XYDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 * @date 2022/4/27 11:09
 * @since
 */
@Component(value = "testBean")
public class TestChart implements DataInject {


    @Override
    public Map<String, List<XYDTO>> inject() {
        //mock Data
        return MockUtil.getMockMap();
    }
}