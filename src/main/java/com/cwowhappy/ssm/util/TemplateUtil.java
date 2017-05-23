package com.cwowhappy.ssm.util;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/**
 * Created by cwowhappy on 17-5-23.
 */
@Component
public class TemplateUtil {
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public String buildContent(String templateName) throws IOException, TemplateException {
        return buildContent(templateName, null);
    }

    public String buildContent(String templateName, Object dataModel) throws IOException, TemplateException {
        return buildContent(templateName, Locale.getDefault(), dataModel);
    }

    public String buildContent(String templateName, Locale locale, Object dataModel) throws IOException, TemplateException {
        Writer writer = new StringWriter();
        freeMarkerConfigurer.getConfiguration().getTemplate(templateName, locale).process(dataModel, writer);
        return writer.toString();
    }

    @Autowired
    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
    }
}
