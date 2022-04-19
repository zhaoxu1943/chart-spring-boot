package com.z.chart.spring.boot.starter.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.stream.Stream;

public class AppContextAware implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.context = applicationContext;
    }

    public void printBeanNames() {
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
