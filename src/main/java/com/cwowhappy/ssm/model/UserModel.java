package com.cwowhappy.ssm.model;

import com.cwowhappy.ssm.common.enums.Gender;
import com.cwowhappy.ssm.domain.UserEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
public class UserModel {
    private String code;
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private LocalDateTime deleteTime;

    public UserModel() {}

    public UserModel(@NotNull UserEntity userEntity) {
        this.setCode(userEntity.getCode());
        this.setName(userEntity.getName());
        this.setGender(userEntity.getGender());
        this.setBirthday(userEntity.getBirthday());
        this.setDeleteTime(userEntity.getDeleteTime());
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }
}
