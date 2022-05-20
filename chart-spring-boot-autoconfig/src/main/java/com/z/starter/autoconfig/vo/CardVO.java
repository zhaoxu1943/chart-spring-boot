package com.z.starter.autoconfig.vo;

import com.z.starter.autoconfig.po.Chart;
import com.z.starter.autoconfig.po.ChartType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardVO extends BaseVO implements Serializable {

    private ChartType defaultChartType;

    private Long defaultChartId;

    private String title;

    private Integer cardOrder;

    private Integer span;

    private Integer cardOffset;

    private List<Chart> charts;
}
