package com.z.starter.autoconfig.po;

import com.z.starter.autoconfig.dto.XYDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
@ToString(callSuper = true)
@Entity
@Table(name = "plg_chart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Chart extends BaseEntity implements Serializable {


    @Column
    private String title;

    @Column
    private ChartType type;

    @Column
    private String xAxisName;

    @Column
    private String yAxisName;

    /**
     * data bind to the chart object
     */

    @Column()
    private String beanName;


    @Transient
    private Map<String, List<XYDTO>> data;


}
