package com.z.starter.autoconfig.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@Data
public class Page {

    public Page() {
    }

    public Page(String pageId, String pageName, List<Card> cardList) {
        this.pageId = pageId;
        this.pageName = pageName;
        this.cardList = cardList;
    }

    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    private String pageId;

    /**
     * page name
     * @author zhaoxu
     */
    private String pageName;

    private List<Card> cardList;

}
