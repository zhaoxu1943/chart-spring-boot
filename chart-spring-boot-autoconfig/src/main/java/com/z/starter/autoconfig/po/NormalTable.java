package com.z.starter.autoconfig.po;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name="plg_normal_table_chart")
@Builder
@Data()
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NormalTable extends Chart{



    @OneToMany(targetEntity = NormalTableColumnConfig.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "plg_relation_normal_table_chart_column",
            joinColumns = {@JoinColumn(name = "column_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="normal_table_chart_id",referencedColumnName = "id")})
    private List<NormalTableColumnConfig> normalTableColumnConfigList;



}
