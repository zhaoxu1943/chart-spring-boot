package com.z.starter.autoconfig.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO extends BaseVO implements Serializable  {

    private Integer numberOfCutPage;

    private String name;

    private List<CardVO> cards;
}