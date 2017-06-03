package com.cwowhappy.ssm.controller;

import com.cwowhappy.ssm.respbody.EmptyRespBody;
import com.cwowhappy.ssm.respbody.RootRespBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Created by cwowhappy on 2017/6/2.
 */
public class BaseManageController {
    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    public RootRespBody<EmptyRespBody> handleMySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException exception) {
        RootRespBody<EmptyRespBody> respBody = new RootRespBody<>();

        respBody.setStatus(RootRespBody.Status.EXCEPTION);
        respBody.setMessage(exception.getMessage());


        return respBody;
    }
}
