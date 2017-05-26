package com.cwowhappy.ssm.common.mybatis.mapper.common.base.select;

import com.cwowhappy.ssm.common.mybatis.mapper.provider.base.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 通用Mapper接口,查询
 *
 * @param <T> 不能为空
 */
public interface SelectCountMapper<T> {

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param record
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    int selectCount(T record);

}