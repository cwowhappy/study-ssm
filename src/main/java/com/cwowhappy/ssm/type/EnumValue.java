package com.cwowhappy.ssm.type;

/**
 * @author cwowhappy
 * 2017-06-06
 */
public interface EnumValue<T> {
    T getValue();
    boolean valueEqual(T value);
}
