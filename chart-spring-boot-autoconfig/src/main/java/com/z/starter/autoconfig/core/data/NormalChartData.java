package com.z.starter.autoconfig.core.data;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class NormalChartData extends BaseData{

    protected List<Map<String,Object>> dataMapList;

}
