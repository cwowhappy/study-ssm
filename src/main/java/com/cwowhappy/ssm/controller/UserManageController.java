package com.cwowhappy.ssm.controller;

import com.cwowhappy.ssm.common.enums.Gender;
import com.cwowhappy.ssm.model.UserModel;
import com.cwowhappy.ssm.propertyeditor.GenderPropertyEditor;
import com.cwowhappy.ssm.query.QueryUserFilter;
import com.cwowhappy.ssm.query.page.PageQueryParam;
import com.cwowhappy.ssm.query.page.PageQueryResult;
import com.cwowhappy.ssm.respbody.EmptyRespBody;
import com.cwowhappy.ssm.respbody.RootRespBody;
import com.cwowhappy.ssm.respbody.ValidErrorRespBody;
import com.cwowhappy.ssm.service.UserManageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
@RestController
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserManageController extends BaseManageController {
    private UserManageService userManageService;
    private MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Gender.class, new GenderPropertyEditor());
    }

    @RequestMapping(path = "/list")
    public RootRespBody<List<UserModel>> findAllUsers() {
        RootRespBody<List<UserModel>> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.SUCCESS);
        respBody.setMessage("处理成功");
        respBody.setData(userManageService.findAllUsers());
        return respBody;
    }

    @RequestMapping(path = "/list/page")
    public RootRespBody<PageQueryResult<UserModel>> findAllUsersInPage(@Valid @RequestBody PageQueryParam<QueryUserFilter> pageQueryParam) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(pageQueryParam));
        return null;
    }

    @RequestMapping(path = "/addInJsonWay", method = RequestMethod.POST)
    public RootRespBody<EmptyRespBody> addUserInJsonWay(@Valid @RequestBody UserModel userModel) throws JsonProcessingException {
        //userManageService.save(userModel);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        System.out.println(objectMapper.writeValueAsString(userModel));
        RootRespBody<EmptyRespBody> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.SUCCESS);
        respBody.setMessage("处理成功");
        return respBody;
    }


    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public RootRespBody<EmptyRespBody> batchDeleteUser(@NotEmpty @RequestParam("userCode") List<String> userCodes) {
        userCodes.forEach(System.out::println);

        RootRespBody<EmptyRespBody> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.SUCCESS);
        respBody.setMessage("处理成功");
        return respBody;
    }

    @ExceptionHandler(BindException.class)
    public RootRespBody<ValidErrorRespBody> handleBindException(BindException exception) {
        RootRespBody<ValidErrorRespBody> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.EXCEPTION);
        respBody.setMessage("校验失败");
        respBody.setData(new ValidErrorRespBody(exception.getBindingResult().getFieldErrors().stream().map(ValidErrorRespBody.FieldError::new).collect(Collectors.toList())));

        return respBody;
    }

    @Autowired
    @Qualifier("messageSource")
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setUserManageService(UserManageService userManageService) {
        this.userManageService = userManageService;
    }
}
