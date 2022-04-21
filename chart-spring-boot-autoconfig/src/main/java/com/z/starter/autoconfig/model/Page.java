package com.z.starter.autoconfig.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhaoxu
 * @date 2022/4/21 16:56
 * @since
 */
@Data
@Entity
@Table(name="plguin_page")
public class Page {

    /**
     * primary key
     * using database autoincrement
     * @author zhaoxu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * page name
     * @author zhaoxu
     */
    @Column()
    private String pageName;



}
