package com.z.starter.autoconfig.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@Data
@Entity
@Table(name="plguin_card")
public class Card {


    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private Integer span;

    @Column()
    private Integer offset;




}
