package com.cwowhappy.ssm.common.mybatis.mapper.common.base.select;

import com.cwowhappy.ssm.common.mybatis.mapper.provider.base.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 通用Mapper接口,查询
 *
 * @param <T> 不能为空
 */
public interface ExistsWithPrimaryKeyMapper<T> {

    /**
     * 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    boolean existsWithPrimaryKey(Object key);

}