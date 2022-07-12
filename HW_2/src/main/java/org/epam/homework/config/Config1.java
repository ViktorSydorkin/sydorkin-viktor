package org.epam.homework.config;

import org.epam.homework.beans.BeanB;
import org.epam.homework.beans.BeanC;
import org.epam.homework.beans.BeanD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public BeanB beanB(@Value("${beanB.name}") final String name, @Value("${beanB.value}") final int value) {
        return new BeanB(name, value);
    }

    @Bean(initMethod = "initBeanC", destroyMethod = "destroyBeanC")
    @DependsOn("beanB")
    public BeanC beanC(@Value("${beanC.name}") final String name, @Value("${beanC.value}") final int value) {
        return new BeanC(name, value);
    }
    @Bean(initMethod = "initBeanD", destroyMethod = "destroyBeanD")
    public BeanD beanD(@Value("${beanD.name}") final String name, @Value("${beanD.value}") final int value) {
        return new BeanD(name, value);
    }
}
