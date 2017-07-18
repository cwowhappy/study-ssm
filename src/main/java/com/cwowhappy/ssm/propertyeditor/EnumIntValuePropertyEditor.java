package com.cwowhappy.ssm.propertyeditor;

import com.cwowhappy.ssm.type.EnumValue;

import java.beans.PropertyEditorSupport;

/**
 * Created by cwowhappy on 2017/6/21.
 */
public class EnumIntValuePropertyEditor<E extends Enum<E> & EnumValue<Integer>> extends PropertyEditorSupport {
    private E[] enums;

    public EnumIntValuePropertyEditor(Class<E> type) {
        super();
        enums = type.getEnumConstants();
    }

    public EnumIntValuePropertyEditor(Class<E> type, Object source) {
        super(source);
        enums = type.getEnumConstants();
    }


    @Override
    public void setAsText(String text) {
        E value = null;
        for(E e : enums) {
            if(e.valueEqual(Integer.parseInt(text))) {
                value = e;
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
