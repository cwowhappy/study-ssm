package com.cwowhappy.ssm.dao;

import com.cwowhappy.ssm.domain.UserEntity;

import java.util.List;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
public interface UserDao {
    List<UserEntity> findAllUsers();

    void save(UserEntity userEntity);
}
