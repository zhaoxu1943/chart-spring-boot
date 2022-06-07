package com.z.starter.autoconfig.repository;


import com.z.starter.autoconfig.po.JudgeWhiteList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface JudgeWhiteListRepository extends BaseRepository<JudgeWhiteList, String>, JpaSpecificationExecutor<JudgeWhiteList> {

    Page<JudgeWhiteList> findAll(Specification<JudgeWhiteList> judgeWhiteListSpecification, Pageable pageable);

    List<JudgeWhiteList> searchAllByValidStatus(Integer validStatus);
}
