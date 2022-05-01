package com.z.starter.autoconfig.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/5/1 10:21
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseData {

    protected List<Dimension> dimensionList;

}
