package com.cwowhappy.ssm.common.mybatis.mapper.common.base;

import com.cwowhappy.ssm.common.mybatis.mapper.common.base.select.*;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 */
public interface BaseSelectMapper<T> extends
        SelectOneMapper<T>,
        SelectMapper<T>,
        SelectAllMapper<T>,
        SelectCountMapper<T>,
        SelectByPrimaryKeyMapper<T>,
        ExistsWithPrimaryKeyMapper<T> {

}