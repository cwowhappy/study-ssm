package com.cwowhappy.ssm.model;

import com.cwowhappy.ssm.domain.UserEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
public class UserModel {
    private String code;
    private String name;
    private LocalDate birthday;

    public UserModel() {}

    public UserModel(@NotNull UserEntity userEntity) {
        this.setCode(userEntity.getCode());
        this.setName(userEntity.getName());
        this.setBirthday(userEntity.getBirthday());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
