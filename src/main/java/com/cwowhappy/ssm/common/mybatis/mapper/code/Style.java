package com.cwowhappy.ssm.common.mybatis.mapper.code;

/**
 * 字段转换方式
 */
public enum Style {
    normal,                     //原值
    camelHump,                  //驼峰转下划线
    uppercase,                  //转换为大写
    lowercase,                  //转换为小写
    camelHumpAndUppercase,      //驼峰转下划线大写形式
    camelHumpAndLowercase,      //驼峰转下划线小写形式
}
