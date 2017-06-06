package com.cwowhappy.ssm.type;

import com.cwowhappy.ssm.common.enums.Gender;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cwowhappy on 2017/6/6.
 */
//@MappedTypes(Gender.class)
//@MappedJdbcTypes({JdbcType.TINYINT, JdbcType.INTEGER})
public class EnumIntValueTypeHandler<E extends Enum<E> & EnumValue<Integer>> extends BaseTypeHandler<E>{
    private final E[] enums;

    public EnumIntValueTypeHandler(Class<E> type) {
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setString(i, parameter.getValue().toString());
        } else {
            ps.setObject(i, parameter.getValue(), jdbcType.TYPE_CODE); // see r3589
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return parseValue(value);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return parseValue(value);
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return parseValue(value);
        }
    }

    private E parseValue(Integer value) {
        E result = null;
        for(E e : enums) {
            if(e.valueEqual(value)) {
                result = e;
            }
        }
        if(null == result) {
            throw new IllegalEnumValueException();
        }
        return result;
    }
}
