package com.cwowhappy.ssm.propertyeditor;

import com.cwowhappy.ssm.common.enums.Gender;

import java.beans.PropertyEditorSupport;

/**
 * Created by cwowhappy on 2017/6/11.
 */
public class GenderPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        Gender value = null;
        for(Gender gender : Gender.values()) {
            if(gender.valueEqual(Integer.parseInt(text))) {
                value = gender;
                break;
            }
        }
        if(null == value) {
            throw new IllegalArgumentException("参数错误");
        } else {
            setValue(value);
        }
    }
}
