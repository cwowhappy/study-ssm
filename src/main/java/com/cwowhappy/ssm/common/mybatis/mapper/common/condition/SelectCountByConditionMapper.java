package com.cwowhappy.ssm.common.mybatis.mapper.common.condition;

import com.cwowhappy.ssm.common.mybatis.mapper.provider.ConditionProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 通用Mapper接口,Condition查询
 *
 * @param <T> 不能为空
 */
public interface SelectCountByConditionMapper<T> {

    /**
     * 根据Condition条件进行查询总数
     *
     * @param condition
     * @return
     */
    @SelectProvider(type = ConditionProvider.class, method = "dynamicSQL")
    int selectCountByCondition(Object condition);

}