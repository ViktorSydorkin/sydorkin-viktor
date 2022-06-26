package org.epam.homework.config;

import org.epam.homework.beans.BeanB;
import org.epam.homework.beans.BeanC;
import org.epam.homework.beans.BeanD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@Import(Config2.class)
@ComponentScan("org.epam.homework.beans")
@PropertySource("classpath:beans.properties")
public class Config1 {
    @Autowired
    Environment environment;
    @Bean(initMethod = "initBeanB", destroyMethod = "destroyBeanB")
    @DependsOn("beanD")
    public BeanB beanB(){
        return new BeanB(environment.getProperty("beanb.name"), Integer.parseInt(Objects.requireNonNull(environment.getProperty("beanb.value"))));
    }
    @Bean(initMethod = "initBeanC", destroyMethod = "destroyBeanC")
    @DependsOn("beanB")
    public BeanC beanC(){
        return new BeanC(environment.getProperty("beanc.name"), Integer.parseInt(Objects.requireNonNull(environment.getProperty("beanc.value"))));
    }
    @Bean(initMethod = "initBeanD", destroyMethod = "destroyBeanD")
    public BeanD beanD(){
        return new BeanD(environment.getProperty("beand.name"), Integer.parseInt(Objects.requireNonNull(environment.getProperty("beand.value"))));
    }


}
