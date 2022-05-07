package com.z.starter.autoconfig.core.data;

import com.z.starter.autoconfig.core.Dimension;
import com.z.starter.autoconfig.core.data.BaseData;
import lombok.Data;

import java.util.List;


@Data
public class BarData extends BaseData {


    //图表使用
    protected List<Dimension> dimensionList;

}
