package com.example.chartspringbootsamples.vo;

import com.z.starter.autoconfig.core.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhaoxu
 * @date 2022/5/1 10:16
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class XData extends BaseData {

    private String testParam;
}
