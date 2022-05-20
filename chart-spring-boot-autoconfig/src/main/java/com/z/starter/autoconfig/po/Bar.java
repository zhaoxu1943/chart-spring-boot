package com.z.starter.autoconfig.po;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name="plg_bar_chart")
@Builder
@Data()
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Bar extends Chart{


    @Column
    private String xAxisName;

    @Column
    private String yAxisName;


}
