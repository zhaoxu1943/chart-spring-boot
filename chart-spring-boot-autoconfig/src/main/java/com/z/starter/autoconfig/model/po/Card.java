package com.z.starter.autoconfig.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@Accessors
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Serializable {

    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    private String cardId;

    private String pageId;

    private Integer span;

    private Integer offset;


}
