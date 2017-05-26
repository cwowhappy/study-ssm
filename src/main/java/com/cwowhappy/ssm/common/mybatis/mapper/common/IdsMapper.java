package com.cwowhappy.ssm.common.mybatis.mapper.common;

import com.cwowhappy.ssm.common.mybatis.mapper.common.ids.DeleteByIdsMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * 通用Mapper接口,根据ids操作
 *
 * @param <T> 不能为空
 */
public interface IdsMapper<T> extends SelectByIdsMapper<T>, DeleteByIdsMapper<T> {

}
