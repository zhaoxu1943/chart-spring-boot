package com.z.starter.autoconfig.po;

import cn.hutool.core.date.DateTime;
import lombok.*;
import lombok.experimental.Accessors;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @Column()
    private Long defaultChartId;

    @Column()
    private String title;

    @Column(nullable = false)
    private Integer span;

    @Column(nullable = false)
    private Integer offset;

    @ManyToMany(targetEntity = Chart.class,cascade = CascadeType.ALL)
    @JoinTable(name = "plg_relation_card_chart",
            joinColumns = {@JoinColumn(name = "card_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="chart_id",referencedColumnName = "id")})
    private List<Chart> charts;

}
