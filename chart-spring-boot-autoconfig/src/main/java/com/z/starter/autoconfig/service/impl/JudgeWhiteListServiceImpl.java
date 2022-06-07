package com.z.starter.autoconfig.service.impl;

import com.z.starter.autoconfig.po.JudgeWhiteList;
import com.z.starter.autoconfig.repository.JudgeWhiteListRepository;
import com.z.starter.autoconfig.service.JudgeWhiteListService;
import com.z.starter.autoconfig.util.DigestUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import javax.annotation.Resource;
import java.util.*;

@Service
public class JudgeWhiteListServiceImpl implements JudgeWhiteListService {
    @Resource
    JudgeWhiteListRepository judgeWhiteListRepository;

    public Date addDay(Date date, int day) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.DATE, day);
        return gc.getTime();
    }

    private void checkWhiteList(JudgeWhiteList judgeWhiteList) {
        if (judgeWhiteList.getId() == null || "".equals(judgeWhiteList.getId())) {
            judgeWhiteList.initId();
        }
        Date nowTime = new Date();
        if (judgeWhiteList.getValidType() == null) {
            judgeWhiteList.setValidType(1);
            judgeWhiteList.setValidStatus(1);
        } else if (1 == judgeWhiteList.getValidType()) {
            judgeWhiteList.setValidStatus(1);
        } else {
            if (judgeWhiteList.getInvalidTime() == null) {
                judgeWhiteList.setInvalidTime(addDay(nowTime, 7));
                judgeWhiteList.setValidStatus(1);
            } else {
                if (nowTime.before(judgeWhiteList.getInvalidTime())) {
                    judgeWhiteList.setValidStatus(1);
                } else {
                    judgeWhiteList.setValidStatus(0);
                }
            }
        }
    }


    @Override
    public JudgeWhiteList createJudgeWhiteList(JudgeWhiteList judgeWhiteList) {
        checkWhiteList(judgeWhiteList);

        judgeWhiteListRepository.save(judgeWhiteList);
        return judgeWhiteList;


    }

    @Override
    public JudgeWhiteList saveJudgeWhiteList(JudgeWhiteList judgeWhiteList) {
        checkWhiteList(judgeWhiteList);
        Optional<JudgeWhiteList> cardOption = judgeWhiteListRepository.findById(judgeWhiteList.getId());
        if (cardOption.isPresent()) {
            JudgeWhiteList one = cardOption.get();
            one.setAlias(judgeWhiteList.getAlias());
            one.setValidStatus(judgeWhiteList.getValidStatus());
            one.setValidType(judgeWhiteList.getValidType());
            one.setInvalidTime(judgeWhiteList.getInvalidTime());
            judgeWhiteListRepository.save(one);
            return one;
        } else {
            judgeWhiteListRepository.save(judgeWhiteList);
            return judgeWhiteList;
        }
    }

    @Override
    public JudgeWhiteList deleteJudgeWhiteList(String ids) {
        List<String> deleteIdsList = new ArrayList<>();
        if (ids != null && ids.contains(",")) {
            String[] split = ids.split(",");
            for (String per : split) {
                deleteIdsList.add(per);
            }


        } else {
            deleteIdsList.add(ids);
        }
        List<JudgeWhiteList> judgeList = judgeWhiteListRepository.findAllById(deleteIdsList);
        judgeWhiteListRepository.deleteAll(judgeList);
        return null;
    }

    @Override
    public List<JudgeWhiteList> loadAllJudgeWhiteList() {
        List<JudgeWhiteList> allList = judgeWhiteListRepository.searchAllByValidStatus(1);

        return allList;
    }

    @Override
    public boolean isWhiteList(String sourceIp, String destinationIp, String alarmEventName) {

        String id = DigestUtils.md5Hex(sourceIp + alarmEventName);
        if (judgeWhiteListRepository.existsById(id)) {
            return true;
        }
        if (destinationIp != null && !"".equals(destinationIp)) {
            String id2 = DigestUtils.md5Hex(sourceIp + alarmEventName + destinationIp);
            if (judgeWhiteListRepository.existsById(id2)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Page<JudgeWhiteList> findByQuery(String sourceIp, String destinationIp, String alarmEventName, Integer
            validStatus, int page, int pageSize) {
        Sort sort = sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(page, pageSize, sort);

        Page<JudgeWhiteList> allList = judgeWhiteListRepository.findAll(new Specification<JudgeWhiteList>() {
            @Override
            public Predicate toPredicate(Root<JudgeWhiteList> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (sourceIp != null && !"".equals(sourceIp)) {
                    list.add(criteriaBuilder.like(root.get("sourceIp").as(String.class), sourceIp + "%"));
                }
                if (destinationIp != null && !"".equals(destinationIp)) {
                    list.add(criteriaBuilder.like(root.get("destinationIp").as(String.class), destinationIp + "%"));
                }
                if (alarmEventName != null && !"".equals(alarmEventName)) {
                    list.add(criteriaBuilder.like(root.get("alarmEventName").as(String.class), "%" + alarmEventName + "%"));
                }
                if (validStatus != null && validStatus > 0) {
                    list.add(criteriaBuilder.equal(root.get("validStatus").as(String.class), validStatus));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageable);
        return null;
    }
}
