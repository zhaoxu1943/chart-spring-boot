package com.z.starter.autoconfig.query;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class PageCardQuery {

    private String pageName;

    private Integer numberOfCutPage;

    private Integer cardNumber;

    private Integer cardSpan;

    private Integer cardOffset;
}
