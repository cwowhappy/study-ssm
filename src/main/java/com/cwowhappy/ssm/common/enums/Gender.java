package com.cwowhappy.ssm.common.enums;

import com.cwowhappy.ssm.type.EnumValue;

import java.util.Objects;

/**
 * Created by cwowhappy on 2017/5/18.
 */
public enum Gender implements EnumValue<Integer> {
    FEMALE(0), MALE(1) ;

    Gender(int value) {
        this.value = value;
    }
    private int value;
    public Integer getValue() {
        return value;
    }
    @Override
    public boolean valueEqual(Integer value) {
        return Objects.equals(this.value, value);
    }
}
