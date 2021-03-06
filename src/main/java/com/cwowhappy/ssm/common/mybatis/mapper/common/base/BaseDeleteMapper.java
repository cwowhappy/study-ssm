package com.cwowhappy.ssm.common.mybatis.mapper.common.base;

import com.cwowhappy.ssm.common.mybatis.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.base.delete.DeleteMapper;

/**
 * 通用Mapper接口,基础删除
 *
 * @param <T> 不能为空
 */
public interface BaseDeleteMapper<T> extends
        DeleteMapper<T>,
        DeleteByPrimaryKeyMapper<T> {
}