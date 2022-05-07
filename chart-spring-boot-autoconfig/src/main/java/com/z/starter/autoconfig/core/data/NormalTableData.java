package com.z.starter.autoconfig.core.data;

import lombok.Data;

import java.util.List;

@Data
public class NormalTableData<T>  extends BaseData{

    //普通列表
    protected List<T> normalTableObjectList;

}
