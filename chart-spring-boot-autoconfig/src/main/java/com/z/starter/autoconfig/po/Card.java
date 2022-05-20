package com.z.starter.autoconfig.po;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name="plg_card")
@Builder
@Data()
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Card extends BaseEntity implements Serializable {


    @Column
    private ChartType defaultChartType;

    @Column
    private Long defaultChartId;

    @Column
    private String title;

    @Column
    private Integer cardOrder;

    @Column(nullable = false)
    private Integer span;

    @Column(nullable = false)
    private Integer cardOffset;

    @ManyToMany(targetEntity = Bar.class,cascade = CascadeType.MERGE)
    @JoinTable(name = "plg_relation_card_bar_chart",
            joinColumns = {@JoinColumn(name = "card_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="bar_chart_id",referencedColumnName = "id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Bar> bars;


    @ManyToMany(targetEntity = NormalTable.class,cascade = CascadeType.MERGE)
    @JoinTable(name = "plg_relation_card_normal_table_chart",
            joinColumns = {@JoinColumn(name = "card_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="normal_table_chart_id",referencedColumnName = "id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NormalTable> normalTables;


}
