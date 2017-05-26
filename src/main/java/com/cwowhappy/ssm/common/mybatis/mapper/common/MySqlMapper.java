package com.cwowhappy.ssm.common.mybatis.mapper.common;

import com.cwowhappy.ssm.common.mybatis.mapper.common.special.InsertListMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * 通用Mapper接口,MySql独有的通用方法
 *
 * @param <T> 不能为空
 */
public interface MySqlMapper<T> extends
        InsertListMapper<T>,
        InsertUseGeneratedKeysMapper<T> {

}