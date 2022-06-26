package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);
        Pet pet = applicationContext.getBean(Pet.class);
        pet.printPets();
        Cheetah cheetah = applicationContext.getBean(Cheetah.class);
        Cheetah cheetah1 = applicationContext.getBean("getCheetahQualifier", Cheetah.class);
    }
}
