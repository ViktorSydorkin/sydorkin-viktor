package org.epam.homework.beans;

public class BeanB extends Bean {
    public BeanB() {
    }

    public BeanB(String name, int value) {
        super(name, value);
    }

    private void initBeanB() {
        System.out.println("BeanB init method");
    }

    private void changedInit() {
        System.out.println("BeanB changed init method");
    }

    private void destroyBeanB() {
        System.out.println("BeamB destroy method");
    }
}
