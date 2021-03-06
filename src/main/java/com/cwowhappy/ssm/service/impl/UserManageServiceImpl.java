package com.cwowhappy.ssm.service.impl;

import com.cwowhappy.ssm.dao.UserDao;
import com.cwowhappy.ssm.domain.UserEntity;
import com.cwowhappy.ssm.model.UserModel;
import com.cwowhappy.ssm.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cwowhappy on 17-5-17.
 */
@Transactional
@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManageServiceImpl.class);
    private UserDao userDao;

    @Override
    public void save(UserModel userModel) {
        if(null != userModel) {
            userDao.insertSelective(new UserEntity(userModel));
        }
    }

    @Override
    public void delete(String userCode) {
        userDao.logicDeleteByCode(userCode, LocalDateTime.now());
    }

    @Override
    public List<UserModel> findAllUsers() {
        List<UserModel> userModelList = null;
        List<UserEntity> userEntityList = userDao.selectAll();
        if(null != userEntityList) {
            userModelList = userEntityList.stream().map(UserModel::new).collect(Collectors.toList());
        }
        return userModelList;
    }



    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
