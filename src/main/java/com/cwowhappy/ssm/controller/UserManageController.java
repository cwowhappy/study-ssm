package com.cwowhappy.ssm.controller;

import com.cwowhappy.ssm.model.UserModel;
import com.cwowhappy.ssm.respbody.EmptyRespBody;
import com.cwowhappy.ssm.respbody.RootRespBody;
import com.cwowhappy.ssm.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
@RestController
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserManageController {
    private UserManageService userManageService;

    @RequestMapping(path = "/list")
    public RootRespBody<List<UserModel>> findAllUsers() {
        RootRespBody<List<UserModel>> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.SUCCESS);
        respBody.setMessage("处理成功");
        respBody.setData(userManageService.findAllUsers());
        return respBody;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public RootRespBody<EmptyRespBody> addUser(UserModel userModel) {
        userManageService.save(userModel);
        RootRespBody<EmptyRespBody> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.SUCCESS);
        respBody.setMessage("处理成功");
        return respBody;
    }

    @Autowired
    public void setUserManageService(UserManageService userManageService) {
        this.userManageService = userManageService;
    }
}
