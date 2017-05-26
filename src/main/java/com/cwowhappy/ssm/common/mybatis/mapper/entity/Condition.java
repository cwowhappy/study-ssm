package com.cwowhappy.ssm.common.mybatis.mapper.entity;

/**
 * Condition - 条件查询，命名就是任性
 */
public class Condition extends Example {
    public Condition(Class<?> entityClass) {
        super(entityClass);
    }

    public Condition(Class<?> entityClass, boolean exists) {
        super(entityClass, exists);
    }

    public Condition(Class<?> entityClass, boolean exists, boolean notNull) {
        super(entityClass, exists, notNull);
    }
}
