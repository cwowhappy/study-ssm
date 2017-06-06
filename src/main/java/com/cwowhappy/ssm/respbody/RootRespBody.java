package com.cwowhappy.ssm.respbody;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.cwowhappy.ssm.common.enums.Gender;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
public class RootRespBody<T> {
    private Status status;
    private String message;
    private T data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public enum Status {
        SUCCESS(200), EXCEPTION(500);

        Status(int value) {
            this.value = value;
        }

        @JsonValue
        public int getValue() {
            return value;
        }

        private int value;

    }
}
