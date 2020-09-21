package com.rx.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class RaoBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("person".equals(beanName) || "student".equals(beanName)) {
            System.out.println(beanName + "--->>>BeanPostProcessor.postProcessBeforeInitialization...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("person".equals(beanName) || "student".equals(beanName)) {
            System.out.println(beanName + "--->>>BeanPostProcessor.postProcessAfterInitialization....");
        }
        return bean;
    }
}
