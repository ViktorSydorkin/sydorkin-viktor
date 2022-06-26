package org.epam.homework.beans;

public class BeanD extends Bean {
    public BeanD() {
    }
    public BeanD(String name, int value) {
        super(name, value);
    }

    private void initBeanD() {
        System.out.println("BeanD init method");
    }

    private void destroyBeanD() {
        System.out.println("BeamD destroy method");
    }
}
