package com.z.starter.autoconfig.model;

import lombok.Data;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@Data

public class Card {


    public Card(String cardId, Integer span, Integer offset) {
        this.cardId = cardId;
        this.span = span;
        this.offset = offset;
    }

    public Card(Integer span, Integer offset) {
        this.span = span;
        this.offset = offset;
    }


    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    private String cardId;

    private Integer span;

    private Integer offset;


}
