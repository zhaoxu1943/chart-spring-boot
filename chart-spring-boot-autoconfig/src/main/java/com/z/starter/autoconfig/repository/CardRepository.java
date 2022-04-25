package com.z.starter.autoconfig.repository;

import com.z.starter.autoconfig.po.Card;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoxu
 * @date 2022/4/25 15:25
 * @since
 */
public interface CardRepository  extends BaseRepository<Card,Long> {
}
