package com.cwowhappy.ssm.controller;

import com.cwowhappy.ssm.respbody.IllegalRequestParamsRespBody;
import com.cwowhappy.ssm.respbody.RootRespBody;
import com.sun.tools.hat.internal.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cwowhappy on 2017/8/22.
 */
public class BaseController {
    protected MessageSource messageSource;


    @ExceptionHandler(BindException.class)
    public RootRespBody<IllegalRequestParamsRespBody> handleBindException(BindException exception) {
        return buildIllegalRequestParamsRespBody(exception.getBindingResult());
    }

    private RootRespBody<IllegalRequestParamsRespBody> buildIllegalRequestParamsRespBody(BindingResult bindingResult) {
        List<String> errors = new ArrayList<>();
        if(null != bindingResult.getGlobalErrors()) {
            errors = bindingResult.getGlobalErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
        }
        List<IllegalRequestParamsRespBody.ParamError> paramErrors = new ArrayList<>();
        if(null != bindingResult.getFieldErrors()) {
            paramErrors = bindingResult.getFieldErrors().stream().map(IllegalRequestParamsRespBody.ParamError::new).collect(Collectors.toList());
        }

        RootRespBody<IllegalRequestParamsRespBody> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.EXCEPTION);
        respBody.setMessage("exception");
        respBody.setData(new IllegalRequestParamsRespBody(errors, paramErrors));

        return respBody;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
