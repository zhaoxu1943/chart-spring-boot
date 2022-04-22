package com.z.starter.autoconfig.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.z.starter.autoconfig.model.Card;
import com.z.starter.autoconfig.model.Page;

import javax.swing.*;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 15:52
 * @since
 */
public class PageCreateUtil {

    /**
     * produce same card with same span
     * @param pageName
     * @param cardNumber number of cards in one page
     * @param cardSpan  span of card
     * @param cardOffset offset
     * @return
     * @throws
     * @author zhaoxu
     */
    public static String createPageStructure(String pageName,int cardNumber,int cardSpan,int cardOffset){
        List<Card> cardList = Lists.newArrayListWithCapacity(cardNumber);
        for (int i = 0; i < cardNumber; i++) {
            cardList.add(new Card(UUID.fastUUID().toString(true),cardSpan,cardOffset));
        }
        Page page = new Page(UUID.fastUUID().toString(true),pageName,cardList);
        return JSONUtil.toJsonStr(page);
    }
}
