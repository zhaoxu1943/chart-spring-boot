package com.z.starter.autoconfig.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zhaoxu
 * @date 2022/4/25 15:43
 * @since
 */
@NoRepositoryBean
public interface BaseRepository<T,Long> extends PagingAndSortingRepository<T,Long>, CrudRepository<T,Long> {



}
