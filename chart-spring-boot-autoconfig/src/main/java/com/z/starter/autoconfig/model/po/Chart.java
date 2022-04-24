package com.z.starter.autoconfig.model.po;

import com.z.starter.autoconfig.config.ChartType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chart implements Serializable {


    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    private Integer id;

    private Integer cardId;

    private ChartType chartType;

    /**
     * data bind to the chart object
     */
    private Object chartData;
}
