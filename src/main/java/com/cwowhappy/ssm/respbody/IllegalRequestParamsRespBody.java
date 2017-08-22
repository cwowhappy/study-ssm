package com.cwowhappy.ssm.respbody;

import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 用户请求参数错误的响应信息
 * @author lixiaoyi
 * 2017-06-12 Monday
 */
public class IllegalRequestParamsRespBody {
    private List<String> errors;
    private List<ParamError> paramErrors;

    public IllegalRequestParamsRespBody() {}

    public IllegalRequestParamsRespBody(List<String> errors, List<ParamError> paramErrors) {
        setErrors(errors);
        setParamErrors(paramErrors);
    }

    public List<ParamError> getParamErrors() {
        return paramErrors;
    }

    public void setParamErrors(List<ParamError> paramErrors) {
        this.paramErrors = paramErrors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


    public static class ParamError {
        private String name;
        private String value;
        private String message;

        public ParamError() {}

        public ParamError(String name, String value, String message) {
            setName(name);
            setValue(value);
            setMessage(message);
        }

        public ParamError(FieldError fieldError) {
            setName(fieldError.getField());
            setValue(null == fieldError.getRejectedValue() ? null : fieldError.getRejectedValue().toString());
            setMessage(fieldError.getDefaultMessage());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
