package org.epam.homework.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA extends Bean implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA destroy");
    }
}
