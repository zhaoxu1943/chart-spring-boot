package com.z.starter.autoconfig.repository;

import com.z.starter.autoconfig.po.Page;

/**
 * @author zhaoxu
 * @date 2022/4/25 15:00
 * @since
 */
public interface PageRepository extends BaseRepository<Page,Long> {

    Page findByName(String name);
}
