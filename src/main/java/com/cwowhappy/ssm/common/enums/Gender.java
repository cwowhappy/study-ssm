package com.cwowhappy.ssm.common.enums;

import com.cwowhappy.ssm.type.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * Created by cwowhappy on 2017/5/18.
 */
public enum Gender implements EnumValue<Integer> {
    FEMALE(10), MALE(11) ;

    Gender(int value) {
        this.value = value;
    }
    private int value;

    @JsonValue
    public Integer getValue() {
        return value;
    }
    @Override
    public boolean valueEqual(Integer value) {
        return Objects.equals(this.value, value);
    }
}
