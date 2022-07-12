package org.epam.homework;

import org.epam.homework.beans.BeanF;
import org.epam.homework.config.Config1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
            System.out.println(context.getBeanDefinition(beanDefinitionName));
        }
        context.getBean("beanF", BeanF.class);
        context.close();
    }
}
