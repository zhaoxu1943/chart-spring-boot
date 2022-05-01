package com.z.starter.autoconfig.core;

import com.z.starter.autoconfig.dto.XYDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/5/1 11:00
 * @since
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dimension{

    private String name;

    private List<XYDTO> xydtoList;

}
