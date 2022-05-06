package com.z.starter.autoconfig.po;

import cn.hutool.db.sql.Direction;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhaoxu
 * @date 2022/5/6 15:48
 * @since
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "plg_normal_table_column_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NormalTableColumnConfig extends BaseEntity implements Serializable {

    @Column
    private String columnKey;

    @Column
    private String columnChineseName;

    @Column
    private String columnEnglishName;

    @Column
    private boolean hide;

    @Column
    private boolean sortable;

    @Column
    private Direction sortDirection;

    @Column
    private Integer columnOrder;

}
