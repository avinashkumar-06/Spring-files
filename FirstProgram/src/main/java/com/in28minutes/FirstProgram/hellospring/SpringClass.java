package com.in28minutes.FirstProgram.hellospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringClass {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(SpringConfigurationClass.class);

        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("dummy"));


        var names = context.getBeanDefinitionNames();

        Arrays.stream(names).forEach(System.out::println);

    }
}
