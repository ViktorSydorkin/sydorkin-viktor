package org.epam.homework.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE extends Bean{

    @PostConstruct
    public void post(){
        System.out.println("BeanE postConstruct");
    }
    @PreDestroy
    public void pre(){
        System.out.println("BeanE preDestroy");
    }
}
