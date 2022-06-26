package org.epam.homework.beans;

public class BeanC extends Bean {

    public BeanC() {
    }
    public BeanC(String name, int value) {
        super(name, value);
    }

    private void initBeanC() {
        System.out.println("BeanC init method");
    }

    private void destroyBeanC() {
        System.out.println("BeamC destroy method");
    }
}
