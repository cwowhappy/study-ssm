package com.cwowhappy.ssm.common.mybatis.mapper.common;


import com.cwowhappy.ssm.common.mybatis.mapper.common.sqlserver.InsertMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.sqlserver.InsertSelectiveMapper;

/**
 * 通用Mapper接口,SqlServerMapper独有的通用方法
 *
 * @param <T> 不能为空
 */
public interface SqlServerMapper<T> extends
        InsertMapper<T>,
        InsertSelectiveMapper<T> {

}