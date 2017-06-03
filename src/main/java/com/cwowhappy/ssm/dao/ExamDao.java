package com.cwowhappy.ssm.dao;

import com.cwowhappy.ssm.common.mybatis.mapper.common.base.insert.InsertSelectiveMapper;
import com.cwowhappy.ssm.common.mybatis.mapper.common.base.select.SelectAllMapper;
import com.cwowhappy.ssm.domain.ExamEntity;

import java.util.List;

/**
 * Created by cwowhappy on 17-5-24.
 */
public interface ExamDao extends InsertSelectiveMapper<ExamEntity>, SelectAllMapper<ExamEntity> {
    List<ExamEntity> findAllExams();
}
