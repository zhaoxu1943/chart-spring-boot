package com.example.chartspringbootsamples.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.dto.XYDTO;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 * @date 2022/4/27 13:46
 * @since
 */
public class MockUtil {

    public static Map<String, List<XYDTO>> getMockMap(){
        //mock Data
        Map<String, List<XYDTO>> map =  Maps.newHashMap();

        List<XYDTO> dnsList = Lists.newArrayList();
        dnsList.add(new XYDTO().setName("10.1.1.1").setValue("22"));
        dnsList.add(new XYDTO().setName("10.1.1.2").setValue("122"));
        dnsList.add(new XYDTO().setName("10.1.1.3").setValue("222"));
        dnsList.add(new XYDTO().setName("10.1.1.4").setValue("222"));
        map.put("DNS",dnsList);

        List<XYDTO> httpList = Lists.newArrayList();
        httpList.add(new XYDTO().setName("10.1.1.1").setValue("221"));
        httpList.add(new XYDTO().setName("10.1.1.2").setValue("122"));
        httpList.add(new XYDTO().setName("10.1.1.3").setValue("222"));
        httpList.add(new XYDTO().setName("10.1.1.4").setValue("222"));
        map.put("HTTP",httpList);

        return map;
    }
}