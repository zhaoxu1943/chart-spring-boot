package com.z.starter.autoconfig.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.model.dto.PageCardDTO;
import com.z.starter.autoconfig.model.po.Card;
import com.z.starter.autoconfig.model.po.Page;

import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/22 15:52
 * @since
 */
public class PageCreateUtil {

    /**
     * produce same card with same span
     * @param pageCardDTO
     * @return
     * @throws
     * @author zhaoxu
     */
    public static Page createPageStructure(PageCardDTO pageCardDTO){
        if (pageCardDTO==null){
            throw new ChartException("PageCardDTO is null Object,cant create page");
        }

        String cardId = UUID.fastUUID().toString(true);

        Integer cardNumber = pageCardDTO.getCardNumber();
        if (cardNumber!=null&&cardNumber>0){
            List<Card> cardList = Lists.newArrayListWithCapacity(cardNumber);
            Integer cardSpan = pageCardDTO.getCardSpan();
            Integer cardOffset = pageCardDTO.getCardOffset();
            if (cardSpan!=null&&cardOffset!=null&&cardSpan>0&&cardOffset>=0){
                for (int i = 0; i < cardNumber; i++) {
                    cardList.add(new Card(UUID.fastUUID().toString(true),cardId,cardSpan,cardOffset));
                }
            }
            String pageName =pageCardDTO.getPageName();
            if(StrUtil.isNotBlank(pageName)){
                return new Page(cardId,pageName,cardList);
            }
        }
            throw new ChartException("IllegalArgument in PageCardDTO");
    }
}
