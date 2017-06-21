package com.cwowhappy.ssm.model;

import com.cwowhappy.ssm.common.enums.Gender;
import com.cwowhappy.ssm.domain.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cwowhappy
 * 2017-05-16 Tuesday
 */
public class UserModel {
    @NotEmpty(message = "{user.code.null}")
    private String code;
    @NotEmpty
    private String name;
    @NotNull
    private Gender gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
