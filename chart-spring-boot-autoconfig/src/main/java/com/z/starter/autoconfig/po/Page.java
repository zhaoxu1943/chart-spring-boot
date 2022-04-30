package com.z.starter.autoconfig.po;

import cn.hutool.core.date.DateTime;
import lombok.*;
import lombok.experimental.Accessors;
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
@Table(name = "plg_page")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Page extends BaseEntity implements Serializable {


    @Column()
    private String name;

    @OneToMany(targetEntity = Card.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "plg_relation_page_card",
            joinColumns = {@JoinColumn(name = "page_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="card_id",referencedColumnName = "id")})
    private List<Card> cards;


}
