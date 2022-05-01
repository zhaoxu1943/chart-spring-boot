package com.z.starter.autoconfig.dto;

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

    private Long id;

    private Map<String,String> queryMap;
}
