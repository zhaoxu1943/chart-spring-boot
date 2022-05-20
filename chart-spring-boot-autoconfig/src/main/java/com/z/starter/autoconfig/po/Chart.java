package com.z.starter.autoconfig.po;

import com.z.starter.autoconfig.core.data.BaseData;
import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;

/**
 * page/card focus on page structure
 * model chart has N-N relation with Card
 * it means that a card can place any chart
 * the same chart can be placed on different cards
 *
 * @author zhaoxu
 * @date 2022/4/21 16:57
 * @since
 */
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class Chart<T extends BaseData> extends BaseEntity implements Serializable {


    @Column
    private String title;

    @Column
    private ChartType type;

    /**
     * data bind to the chart object
     */
    @Column()
    private String beanName;

    @Transient
    private T data;

}
