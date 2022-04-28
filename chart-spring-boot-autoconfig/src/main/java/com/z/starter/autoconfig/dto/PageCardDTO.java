package com.z.starter.autoconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhaoxu
 * @date 2022/4/24 13:53
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageCardDTO {


    private String pageName;

    private Integer cardNumber;

    private Integer cardSpan;

    private Integer cardOffset;
}
