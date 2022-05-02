package com.example.chartspringbootsamples.util;

import com.example.chartspringbootsamples.vo.XData;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.starter.autoconfig.core.Dimension;
import com.z.starter.autoconfig.core.XYAxis;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 * @date 2022/4/27 13:46
 * @since
 */
public class MockUtil {

    public static Map<String, List<XYAxis>> getMockMap(){
        //mock Data
        Map<String, List<XYAxis>> map =  Maps.newHashMap();

        List<XYAxis> dnsList = Lists.newArrayList();
        dnsList.add(new XYAxis().setName("10.1.1.1").setValue("22"));
        dnsList.add(new XYAxis().setName("10.1.1.2").setValue("122"));
        dnsList.add(new XYAxis().setName("10.1.1.3").setValue("222"));
        dnsList.add(new XYAxis().setName("10.1.1.4").setValue("222"));
        map.put("DNS",dnsList);

        List<XYAxis> httpList = Lists.newArrayList();
        httpList.add(new XYAxis().setName("10.1.1.1").setValue("221"));
        httpList.add(new XYAxis().setName("10.1.1.2").setValue("122"));
        httpList.add(new XYAxis().setName("10.1.1.3").setValue("222"));
        httpList.add(new XYAxis().setName("10.1.1.4").setValue("222"));
        map.put("HTTP",httpList);

        return map;
    }



    public static XData getBaseDataMockMap(){

        List<Dimension> dimensionList = Lists.newArrayList();

        Dimension dnsDimension = new Dimension();

        List<XYAxis> dnsList = Lists.newArrayList();
        dnsList.add(new XYAxis().setName("10.1.1.1").setValue("22"));
        dnsList.add(new XYAxis().setName("10.1.1.2").setValue("122"));
        dnsList.add(new XYAxis().setName("10.1.1.3").setValue("222"));
        dnsList.add(new XYAxis().setName("10.1.1.4").setValue("222"));
        dnsDimension.setName("DNS").setXYAxisList(dnsList);


        Dimension httpDimension = new Dimension();

        List<XYAxis> httpList = Lists.newArrayList();
        httpList.add(new XYAxis().setName("10.1.1.1").setValue("221"));
        httpList.add(new XYAxis().setName("10.1.1.2").setValue("122"));
        httpList.add(new XYAxis().setName("10.1.1.3").setValue("222"));
        httpList.add(new XYAxis().setName("10.1.1.4").setValue("222"));
        httpDimension.setName("HTTP").setXYAxisList(httpList);

        dimensionList.add(dnsDimension);
        dimensionList.add(httpDimension);

        XData xData = new XData();
        xData.setDimensionList(dimensionList);
        xData.setTestParam("123");
        return xData;
    }


}
