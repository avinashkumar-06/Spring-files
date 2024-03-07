package com.avinashcodes.postconstructandpredestroy;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class AppLauncher {

    public static void main(String[] args) {

        try(var ctxt = new AnnotationConfigApplicationContext(AppLauncher.class)){

            Arrays.stream(ctxt.getBeanDefinitionNames()).forEach(System.out::println);

            ctxt.getBean(DemoClass.class).normalMethod();


        }



    }


}
