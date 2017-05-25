package com.cwowhappy.ssm.dao;

import com.cwowhappy.ssm.domain.ExamEntity;

import java.util.List;

/**
 * Created by cwowhappy on 17-5-24.
 */
public interface ExamDao {
    List<ExamEntity> findAllExams();

    void save(ExamEntity examEntity);
}
