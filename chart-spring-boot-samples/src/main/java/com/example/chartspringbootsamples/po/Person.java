package com.example.chartspringbootsamples.po;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhaoxu
 * @date 2022/5/6 16:23
 * @since
 */
@Data
@Accessors(chain = true)
public class Person {

    private String name;

    private Integer age;
}
