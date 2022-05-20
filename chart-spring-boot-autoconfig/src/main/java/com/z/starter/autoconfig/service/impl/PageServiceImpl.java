package com.z.starter.autoconfig.service.impl;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.z.starter.autoconfig.config.ChartException;
import com.z.starter.autoconfig.po.*;
import com.z.starter.autoconfig.query.PageCardQuery;
import com.z.starter.autoconfig.repository.CardRepository;
import com.z.starter.autoconfig.repository.PageRepository;
import com.z.starter.autoconfig.service.PageService;
import com.z.starter.autoconfig.util.VOMapUtil;
import com.z.starter.autoconfig.vo.PageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {


    @Resource
    PageRepository pageRepository;

    @Resource
    CardRepository cardRepository;


    @Override
    @Transactional
    public Page createPage(PageCardQuery pageCardQuery)  {
        if (pageCardQuery ==null){
            throw new ChartException("Cant create page, pageCardQuery is null!");
        }
        //create Card
        Integer cardNumber = pageCardQuery.getCardNumber();
        List<Card> cardList = Lists.newArrayListWithCapacity(cardNumber);
        if (cardNumber!=null&&cardNumber>0){
            Integer cardSpan = pageCardQuery.getCardSpan();
            Integer cardOffset = pageCardQuery.getCardOffset();
            if (cardSpan!=null&&cardOffset!=null&&cardSpan>0&&cardOffset>=0){
                for (int i = 0; i < cardNumber; i++) {
                    cardList.add(new Card().setSpan(cardSpan).setCardOffset(cardOffset));
                    cardRepository.saveAll(cardList);
                }
            }
            String pageName = pageCardQuery.getPageName();
            if(StrUtil.isNotBlank(pageName)){
                Page page = new Page()
                        .setName(pageName)
                        .setNumberOfCutPage(pageCardQuery.getNumberOfCutPage())
                        .setCards(cardList);
                pageRepository.save(page);
                return page;
            }
        }else{
            String pageName = pageCardQuery.getPageName();
            if(StrUtil.isNotBlank(pageName)){
                Page page = new Page().setName(pageName);
                return pageRepository.save(page);
            }
        }
            throw new ChartException("IllegalArgument in PageCardDTO!");
    }

    @Override
    public PageVO getPageInfo(String pageName) {
        Optional<Page> pageOptional = pageRepository.findByName(pageName);
        if (pageOptional.isPresent()){
            Page page = pageOptional.get();
            return VOMapUtil.pageToPageVO(page);
        }
        throw new ChartException("Cant find page by given pageName!");
    }
}
