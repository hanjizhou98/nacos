package com.example.nacos.util;

import org.springframework.beans.BeansException;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextUtil.applicationContext == null) {
            SpringContextUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String param) {
        return getApplicationContext().getBean(param);
    }

    public static <T> T getBean(Class<T> clazz) {
        T test = getApplicationContext().getBean(clazz);
        return test;
    }

    public static <T> T getBean(String param, Class<T> clazz) {
        return getApplicationContext().getBean(param, clazz);
    }
}

