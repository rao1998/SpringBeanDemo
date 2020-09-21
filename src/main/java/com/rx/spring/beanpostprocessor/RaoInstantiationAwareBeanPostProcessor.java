package com.rx.spring.beanpostprocessor;

import com.rx.spring.domain.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

@Component
public class RaoInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("person".equals(beanName) || "student".equals(beanName)) {
            System.out.println(beanName + "--->>>InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation....");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("person".equals(beanName) || "student".equals(beanName)) {
            System.out.println(beanName + "--->>>InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation....");
        }
        return bean instanceof Person;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "--->>>InstantiationAwareBeanPostProcessor.postProcessProperties...");
        PropertyValue[] propertyValues = pvs.getPropertyValues();

        for (PropertyValue propertyValue : propertyValues) {
            if ("name".equals(propertyValue.getName())) {
                propertyValue.setConvertedValue("改后rx");
            }
        }
        return pvs;
    }
}
