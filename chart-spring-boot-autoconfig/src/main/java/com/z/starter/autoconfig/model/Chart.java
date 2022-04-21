package com.z.starter.autoconfig.model;

import com.z.starter.autoconfig.ChartType;
import lombok.Data;

import javax.persistence.*;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:57
 * @since
 */
@Data
@Entity
@Table(name="plguin_chart")
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
