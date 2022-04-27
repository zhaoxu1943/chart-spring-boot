package com.z.starter.autoconfig.core;

import com.z.starter.autoconfig.dto.XYDTO;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 * @date 2022/4/27 10:54
 * @since
 */
public interface DataInject {

    Map<String, List<XYDTO>> inject();
}
