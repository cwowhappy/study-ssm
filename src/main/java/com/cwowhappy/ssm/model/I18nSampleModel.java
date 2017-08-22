package com.cwowhappy.ssm.model;

import javax.validation.constraints.NotNull;

/**
 * Created by cwowhappy on 2017/8/22.
 */
public class I18nSampleModel {
    @NotNull(message = "{i18n.name.null}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
