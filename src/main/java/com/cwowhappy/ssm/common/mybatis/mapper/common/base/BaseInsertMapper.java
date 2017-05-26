package com.cwowhappy.ssm.common.mybatis.mapper.common.base;

import com.cwowhappy.ssm.common.mybatis.mapper.common.base.insert.InsertMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 */
public interface BaseInsertMapper<T> extends
        InsertMapper<T>,
        InsertSelectiveMapper<T> {
}