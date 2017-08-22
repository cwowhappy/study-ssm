package com.cwowhappy.ssm.controller;

import com.cwowhappy.ssm.model.I18nSampleModel;
import com.cwowhappy.ssm.respbody.EmptyRespBody;
import com.cwowhappy.ssm.respbody.RootRespBody;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;
import java.util.Locale;

/**
 * 国际化例子
 * @author cwowhappy
 * 2017-08-22 Tuesday
 */
@RestController
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class I18nSampleController extends BaseController {

    @RequestMapping(path = "/i18n/sample", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RootRespBody<EmptyRespBody> sample(@Valid I18nSampleModel model, Locale locale) {
        System.out.println(model.getName());
        RootRespBody<EmptyRespBody> respBody = new RootRespBody<>();
        respBody.setStatus(RootRespBody.Status.SUCCESS);
        respBody.setMessage(messageSource.getMessage("success", null, locale));
        respBody.setData(EmptyRespBody.newInstance());
        return respBody;
    }
}
