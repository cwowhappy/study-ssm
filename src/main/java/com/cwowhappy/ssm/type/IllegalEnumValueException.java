package com.cwowhappy.ssm.type;

/**
 * Created by cwowhappy on 2017/6/6.
 */
public class IllegalEnumValueException extends RuntimeException {
    public IllegalEnumValueException() {}

    public IllegalEnumValueException(String enumValue) {
        super("不合法的枚举值[" + enumValue + "]");
    }
}
