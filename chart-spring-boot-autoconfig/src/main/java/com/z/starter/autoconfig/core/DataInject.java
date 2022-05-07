package com.z.starter.autoconfig.core;

import com.z.starter.autoconfig.core.data.BaseData;
import com.z.starter.autoconfig.query.ChartQuery;

/**
 * inject data to chart
 * @author zhaoxu
 * @date 2022/4/27 10:54
 * @since
 */
@FunctionalInterface
public interface DataInject<T extends BaseData> {

    T injectWithQuery(ChartQuery chartQuery);
}
