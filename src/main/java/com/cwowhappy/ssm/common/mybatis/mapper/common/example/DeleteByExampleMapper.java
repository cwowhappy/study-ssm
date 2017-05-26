package com.cwowhappy.ssm.common.mybatis.mapper.common.example;

import com.cwowhappy.ssm.common.mybatis.mapper.provider.ExampleProvider;
import org.apache.ibatis.annotations.DeleteProvider;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T> 不能为空
 */
public interface DeleteByExampleMapper<T> {

    /**
     * 根据Example条件删除数据
     *
     * @param example
     * @return
     */
    @DeleteProvider(type = ExampleProvider.class, method = "dynamicSQL")
    int deleteByExample(Object example);

}