package com.cwowhappy.ssm.service;

import com.cwowhappy.ssm.model.UserModel;

import java.util.List;

/**
 * Created by cwowhappy on 17-5-17.
 */
public interface UserManageService {
    void save(UserModel userModel);
    void delete(String userCode);
    List<UserModel> findAllUsers();
}
