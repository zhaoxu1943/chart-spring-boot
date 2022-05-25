package com.z.starter.autoconfig.po;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name="plg_normal_chart")
@Builder
@Data()
@NoArgsConstructor
@Accessors(chain = true)
public class NormalChart extends Chart{
}
