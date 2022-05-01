package com.z.starter.autoconfig.core;

import com.z.starter.autoconfig.dto.ChartQuery;

import java.util.Map;

/**
 * inject data to chart
 * @author zhaoxu
 * @date 2022/4/27 10:54
 * @since
 */
public interface DataInject<T extends BaseData> {

    T injectWithQuery(ChartQuery chartQuery);
}
