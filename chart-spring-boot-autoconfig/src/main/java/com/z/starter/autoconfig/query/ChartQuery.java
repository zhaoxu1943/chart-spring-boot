package com.z.starter.autoconfig.query;

import com.z.starter.autoconfig.po.ChartType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author zhaoxu
 * @date 2022/5/1 9:26
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ChartQuery {

    private ChartType chartType;

    private Long id;

    private Map<String,Object> queryMap;
}
