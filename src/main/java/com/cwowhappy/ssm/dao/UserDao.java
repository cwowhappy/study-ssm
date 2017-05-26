package com.cwowhappy.ssm.dao;

import com.cwowhappy.ssm.common.mybatis.mapper.common.base.insert.InsertSelectiveMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.base.select.SelectAllMapper;
import com.cwowhappy.ssm.domain.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
public interface UserDao extends InsertSelectiveMapper<UserEntity>, SelectAllMapper<UserEntity> {
    /**
     * 查询获取所有的用户信息
     * @return 用户信息列表
     */
    List<UserEntity> findAllUsers();

    /**
     * 根据code逻辑删除记录
     * @param code code
     */
    void logicDeleteByCode(@Param("code") String code, @Param("deleteTime") LocalDateTime deleteTime);
}
