package com.z.starter.autoconfig.model.po;

import com.z.starter.autoconfig.model.po.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {


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

    @OneToMany
    private List<Card> cardList;

}
