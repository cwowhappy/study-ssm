package com.cwowhappy.ssm.json;

import com.cwowhappy.ssm.common.enums.Gender;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by cwowhappy on 2017/6/29.
 */
public class GenderDeserializer extends JsonDeserializer<Gender> {
    @Override
    public Gender deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getValueAsString();
        Gender gender = null;
        for(Gender tempGender : Arrays.asList(Gender.values())) {
            if(tempGender.valueEqual(Integer.parseInt(value))) {
                gender = tempGender;
                break;
            }
        }
        return gender;
    }
}
