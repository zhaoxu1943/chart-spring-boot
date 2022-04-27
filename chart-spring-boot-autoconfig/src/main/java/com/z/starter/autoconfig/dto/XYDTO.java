package com.z.starter.autoconfig.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhaoxu
 * @date 2022/4/24 17:26
 * @since
 */
@Data
@Accessors(chain = true)
public class XYDTO {

    private String name;

    private String value;

}
