package com.example.hiber.school;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class StudentBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(CheckPostProcessor.class)){
          Field[] fields= bean.getClass().getDeclaredFields();
          for (Field field:fields){
              if(field.isAnnotationPresent(CheckPostProcessorName.class)){
                field.setAccessible(true);
                  try {
                      System.out.println((String) field.get(bean));
                     field.set(bean,"postPr");
                  } catch (IllegalAccessException e) {
                      e.printStackTrace();
                  }

              }
          }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
