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
    private String title;

    @Column(nullable = false)
    private Integer span;

    @Column(nullable = false)
    private Integer offset;

    @ManyToMany
    @JoinTable(name = "plg_relation_card_chart")
    private List<Chart> charts;

}