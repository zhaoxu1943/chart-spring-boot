package com.z.starter.autoconfig.repository;

import com.z.starter.autoconfig.po.Page;

import java.util.Optional;

/**
 * @author zhaoxu
 * @date 2022/4/25 15:00
 * @since
 */
public interface PageRepository extends BaseRepository<Page,Long> {

    Optional<Page> findByName(String name);
}
