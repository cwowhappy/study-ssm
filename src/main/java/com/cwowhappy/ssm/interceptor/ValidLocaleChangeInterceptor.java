package com.cwowhappy.ssm.interceptor;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by cwowhappy on 2017/8/22.
 */
public class ValidLocaleChangeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException(
                    "No LocaleResolver found: not in a DispatcherServlet request?");
        }
        Locale locale = localeResolver.resolveLocale(request);
        LocaleContextHolder.setLocale(locale, true);
        return true;
    }
}
