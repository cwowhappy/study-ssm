package com.cwowhappy.ssm.common.mybatis.mapper.common;


import com.cwowhappy.ssm.common.mybatis.mapper.common.condition.*;

/**
 * 通用Mapper接口,Condition查询
 *
 * @param <T> 不能为空
 */
public interface ConditionMapper<T> extends
        SelectByConditionMapper<T>,
        SelectCountByConditionMapper<T>,
        DeleteByConditionMapper<T>,
        UpdateByConditionMapper<T>,
        UpdateByConditionSelectiveMapper<T> {

}