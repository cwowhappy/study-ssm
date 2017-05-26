package com.cwowhappy.ssm.common.mybatis.mapper.common.base;

import com.cwowhappy.ssm.common.mybatis.mapper.common.base.update.UpdateByPrimaryKeyMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 */
public interface BaseUpdateMapper<T> extends
        UpdateByPrimaryKeyMapper<T>,
        UpdateByPrimaryKeySelectiveMapper<T> {

}