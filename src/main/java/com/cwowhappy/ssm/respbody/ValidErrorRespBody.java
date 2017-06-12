package com.cwowhappy.ssm.respbody;

import java.util.List;

/**
 * Created by cwowhappy on 2017/6/8.
 */
public class ValidErrorRespBody {
    private List<FieldError> fieldErrors;

    public ValidErrorRespBody() {}

    public ValidErrorRespBody(List<FieldError> fieldErrors) {
        setFieldErrors(fieldErrors);
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public static class FieldError {
        private String field;
        private String message;

        public FieldError() {}

        public FieldError(org.springframework.validation.FieldError fieldError) {
            setField(fieldError.getField());
            setMessage(fieldError.getDefaultMessage());
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
