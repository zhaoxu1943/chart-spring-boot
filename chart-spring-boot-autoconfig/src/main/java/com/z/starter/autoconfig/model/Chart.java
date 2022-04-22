package com.z.starter.autoconfig.model;

import com.z.starter.autoconfig.ChartType;
import lombok.Data;

import javax.persistence.*;

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
@Data
@Entity
public class Chart {


    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private Integer cardId;

    @Column()
    private ChartType chartType;

    /**
     * data bind to the chart object
     */
    private Object chartData;
}
