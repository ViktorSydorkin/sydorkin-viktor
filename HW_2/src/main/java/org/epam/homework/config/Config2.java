package org.epam.homework.config;

import org.epam.homework.beans.BeanF;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.epam.homework.beans")
@PropertySource("classpath:beans.properties")
public class Config2 {
    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}
