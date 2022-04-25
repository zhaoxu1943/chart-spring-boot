package com.z.starter.autoconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoxu
 * @date 2022/4/24 13:53
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageCardDTO {


    private String pageName;

    private Integer cardNumber;

    private Integer cardSpan;

    private Integer cardOffset;
}
