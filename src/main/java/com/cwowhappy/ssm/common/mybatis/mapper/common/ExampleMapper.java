package com.cwowhappy.ssm.common.mybatis.mapper.common;


import com.cwowhappy.ssm.common.mybatis.mapper.common.example.*;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T> 不能为空
 */
public interface ExampleMapper<T> extends
        SelectByExampleMapper<T>,
        SelectCountByExampleMapper<T>,
        DeleteByExampleMapper<T>,
        UpdateByExampleMapper<T>,
        UpdateByExampleSelectiveMapper<T> {

}