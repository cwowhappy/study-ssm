package com.cwowhappy.ssm.model;

import com.cwowhappy.ssm.domain.ExamEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by cwowhappy on 17-5-23.
 */
public class ExamModel {
    private String code;
    private String subject;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;

    public ExamModel() {}

    public ExamModel(@NotNull ExamEntity examEntity) {
        setCode(examEntity.getCode());
        setSubject(examEntity.getSubject());
        setBeginTime(examEntity.getBeginTime());
        setEndTime(examEntity.getEndTime());
        setCreateTime(examEntity.getCreateTime());
        setUpdateTime(examEntity.getUpdateTime());
        setDeleteTime(examEntity.getDeleteTime());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }
}
