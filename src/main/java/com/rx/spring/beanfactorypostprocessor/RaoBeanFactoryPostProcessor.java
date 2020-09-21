package com.rx.spring.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class RaoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor.postProcessBeanFactory...");

        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanStr) {
            if ("person".equals(beanName)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                MutablePropertyValues m = beanDefinition.getPropertyValues();

                if (m.contains("address")) {
                    //这个方法是判断是否有propertyName=username，有就替换，没有就添加
                    m.addPropertyValue("address", "大兴区");
                    System.out.println("postProcessBeanFactory***修改了address属性初始值了***");
                }
            }
        }
    }
}
